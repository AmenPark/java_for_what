import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


import java.util.Random;

public class Protocol {
	static String uri = "http://주소/";
	static Random _r = new Random();
	static final String boundary = "*****";
	static final String crlf = "\r\n";
	static final String twoHyphens = "--";
	static final String delimiter = twoHyphens + boundary + crlf;

	public static String gen(int k) {
		StringBuffer sb = new StringBuffer();
		int r = 0;
		for (; k > 0; k--) {
			r = _r.nextInt(10 + 52);
			if (r < 10) {
				sb.append(r);
			} else if (r < 36) {
				sb.append((char) (55 + r));
			} else {
				sb.append((char) (97 - 36 + r));
			}
		}
		return sb.toString();
	}

	public static int do_join(String id, String pw) {
		String joiner = "http://주소/member.reg.do";
		HttpURLConnection huc = null;
		try {
			byte[] buffer;
			URL url = new URL(joiner);
			huc = (HttpURLConnection) url.openConnection();

			huc.setRequestMethod("POST");
			huc.setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary=" + boundary);
			huc.setDoInput(true);
			huc.setDoOutput(true);
			huc.setUseCaches(false);
			huc.setConnectTimeout(1000);

			OutputStream os = huc.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(huc.getOutputStream(), "utf-8");
			PrintWriter pwriter = new PrintWriter(osw, true);

			StringBuilder sb = new StringBuilder();
			sb.append(delimiter).append("Content-Disposition: form-data; name=\"").append("bm_id").append("\"")
					.append(crlf).append(crlf).append(id).append(crlf);
			sb.append(delimiter).append("Content-Disposition: form-data; name=\"").append("bm_pw").append("\"")
					.append(crlf).append(crlf).append(pw).append(crlf);
			sb.append(delimiter).append("Content-Disposition: form-data; name=\"").append("bm_name").append("\"")
					.append(crlf).append(crlf).append(gen(6)).append(crlf);
			sb.append(delimiter).append("Content-Disposition: form-data; name=\"").append("bm_y").append("\"")
					.append(crlf).append(crlf).append(1923 + _r.nextInt(100) + "").append(crlf);
			sb.append(delimiter).append("Content-Disposition: form-data; name=\"").append("bm_m").append("\"")
					.append(crlf).append(crlf).append(_r.nextInt(12) + 1 + "").append(crlf);
			sb.append(delimiter).append("Content-Disposition: form-data; name=\"").append("bm_d").append("\"")
					.append(crlf).append(crlf).append(_r.nextInt(28) + 1 + "").append(crlf);
			sb.append(delimiter).append("Content-Disposition: form-data; name=\"").append("bm_addr1").append("\"")
					.append(crlf).append(crlf).append(10000 + _r.nextInt(90000) + "").append(crlf);
			sb.append(delimiter).append("Content-Disposition: form-data; name=\"").append("bm_addr2").append("\"")
					.append(crlf).append(crlf).append(gen(25)).append(crlf);
			sb.append(delimiter).append("Content-Disposition: form-data; name=\"").append("bm_addr3").append("\"")
					.append(crlf).append(crlf).append(gen(25)).append(crlf);


			sb.append(delimiter);
			sb.append("Content-Disposition: form-data; name=\"").append("bm_photo")
					.append("\";filename=\"").append("Fake"+gen(20)+".jpg").append("\"").append(crlf);

			try {
	            DataOutputStream ds = new DataOutputStream(huc.getOutputStream());
	            ds.write(sb.toString().getBytes());

	            ds.writeBytes(crlf);
	            FileInputStream fStream = new FileInputStream(new File("D:\\imgs\\"+_r.nextInt(9)+".png"));
	            buffer = new byte[200000];
	            int length = -1;
	            while ((length = fStream.read(buffer)) != -1) {
	                ds.write(buffer, 0, length);
	            }
	            ds.writeBytes(crlf);
	            ds.writeBytes(crlf);
	            ds.writeBytes(twoHyphens + boundary + twoHyphens + crlf); // requestbody end
	            fStream.close();

	            ds.flush();
	            ds.close();
	            
	            int responseCode = huc.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                String line = null;
	                BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
	                while ((line = br.readLine()) != null) {
//	                   System.out.println(line);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
			System.out.println("==================================");
			pwriter.write(sb.toString());
			DataOutputStream request = new DataOutputStream(os);

			int status = huc.getResponseCode();
			System.out.println(status);
			request.close();
			os.close();
			huc.disconnect();
			return status;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return -1;

	}
	
	public static void login(String id, String pw) {
		String url = uri + "member.login";
		
	}
	
	public static void writeGeul(String head) {
		String url = uri+String.format("sns.post.write?token=%s&bs_txt=%s",gen(6),gen(_r.nextInt(200)+1));
//		http://192.168.0.157/bpbascp/sns.post.write?token=043855&bs_txt=test
		HttpURLConnection huc = null;
		try {
			URL u = new URL(url);
			huc = (HttpURLConnection) u.openConnection();
			huc.setRequestProperty("Cookie", head);
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("글등록함");
			br.readLine();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		huc.disconnect();
	}
	
	public static void main(String[] args) {
		final int ACCOUNT = 10;
		final int writeNum = 100;
		ArrayList<ArrayList<String>> accountinfo = new ArrayList();
		
		for(int i=0;i<ACCOUNT;) {
			String id = gen(6);
			String pw = gen(6);
	//		id = "N8JMRFt";
	//		pw = "wfMpoOV";
			if(do_join(id, pw)==200) {
				i++;
				ArrayList<String> info = new ArrayList();
				info.add(id);
				info.add(pw);
				accountinfo.add(info);
			};
		}
		
		for(int i=0;i<writeNum;i++) {
			int accNum = _r.nextInt(ACCOUNT);
			HashMap<String,String> hs = new HashMap();
			hs.put("bm_id", accountinfo.get(accNum).get(0));
			hs.put("bm_pw", accountinfo.get(accNum).get(1));
			String cookie = performPostCall(uri+"member.login", hs).get(0);
			writeGeul(cookie);
			
		}
		
		System.out.println(accountinfo);
	}
	
	
	
	public static List<String>  performPostCall(String requestURL,
            HashMap<String, String> postDataParams) {

        URL url;
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
            	return conn.getHeaderFields().get("Set-Cookie");
            }
            else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
	
	 private static String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException{
	        StringBuilder result = new StringBuilder();
	        boolean first = true;
	        for(Entry<String, String> entry : params.entrySet()){
	            if (first)
	                first = false;
	            else
	                result.append("&");

	            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
	            result.append("=");
	            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
	        }

	        return result.toString();
	    }
}
