package com.fsoft.bn.portlet.publicadministrationprocedure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;

import sun.net.www.protocol.http.HttpURLConnection;

@SuppressWarnings("deprecation")
public class PublicAdministrationProcedureHttpUtill {
	public static String getHTML(String urlToRead) {
	      URL url;
	      HttpURLConnection conn;
	      BufferedReader rd;
	      String line;
	      String result = "";
	      try {
	         url = new URL(urlToRead);
	         conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         conn.setRequestProperty("Content-Type", "application/json");
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         while ((line = rd.readLine()) != null) {
	            result += line;
	         }
	         rd.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return result;
	   }
	
	/**
	 * Gets the ticket authen alfresco.
	 *
	 * @return the ticket authen alfresco
	 */
	public static String getTicketAuthenAlfresco(String url) {
//		try {
//
////			DefaultHttpClient httpClient = new DefaultHttpClient();
////			HttpGet getRequest = new HttpGet(url);
////			getRequest.addHeader("accept", "application/json");
////
////			HttpResponse response = httpClient.execute(getRequest);
////
////			if (response.getStatusLine().getStatusCode() != 200) {
////				throw new RuntimeException("Failed : HTTP error code : "
////						+ response.getStatusLine().getStatusCode());
////			}
////
////			BufferedReader br = new BufferedReader(new InputStreamReader(
////					(response.getEntity().getContent())));
////
////			String output;
////			String ticketReturn = "";
////			while ((output = br.readLine()) != null) {
////				if (output.startsWith("<ticket>")) {
////					ticketReturn = output;
////					int length = ticketReturn.length();
////					ticketReturn = ticketReturn.substring(8, length - 9);
////					return ticketReturn;
////				}
////			}
////			
////			httpClient.getConnectionManager().shutdown();
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return "";
	}
	
	public static String httpGetFromServer(String urlRequest){
		String strReturn = "";
		
//		DefaultHttpClient httpClient = new DefaultHttpClient();
//		HttpGet getRequest = new HttpGet(urlRequest);
//		getRequest.addHeader("accept", "application/json");
//		
//		HttpResponse response;
//		try {
//			response = httpClient.execute(getRequest);
//			if (response.getStatusLine().getStatusCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//						+ response.getStatusLine().getStatusCode());
//			}
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					(response.getEntity().getContent())));
//
//			String output;
//			while ((output = br.readLine()) != null) {
//				strReturn +=output;
//			}			
//			httpClient.getConnectionManager().shutdown();
//			
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return strReturn;
	}
}
