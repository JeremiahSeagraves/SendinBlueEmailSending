package app;

import java.util.HashMap;
import java.util.Map;

import com.sendinblue.Sendinblue;

public class Main {
	
	public static void main(String[] args) {
		
		String apiUrl = "https://api.sendinblue.com/v2.0";
		String apiKey = "JsT5pLOhk3CWNZVt";
		
		Sendinblue http = new Sendinblue(apiUrl,apiKey);
        
		//createFolder(http,"Carpeta de listas");
		//createList(http, "Lista de clientes", 2);
		//createList(http, "Lista de prospectos", 2);
		
		String usuarios = "NAME;SURNAME;EMAIL\n"
        		+ "\"Jeremiah1\";\"Yo1\";\"j.m.s.p.jerry@gmail.com\"\n"
        		+ "\"Jeremiah2\";\"Yo2\";\"jeremiah.seagraves@outlook.com\"\n"
        		+ "\"Mauricio1\";\"Mau1\";\"mangeles@plenumsoft.com.mx\"\n"
        		+ "\"Domingo1\";\"Dom1\";\"edominguez@plenumsoft.com.mx\"\n"
        		+ "\"Mauricio2\";\"Mau2\";\"mauangelesm@gmail.com\"\n"
        		+ "\"Domingo2\";\"Dom2\";\"domingo.eduardo.dg@gmail.com\n"
        		+ "\"Domingo3\";\"Dom3\";\"domingo_eduardo_dg@hotmail.com\"";
		
		//createCampaign(http);
		importUsers(http, usuarios, new int[]{19,20});
		//campaignDetails(http, 11);
		
	}
	
	private static void campaignDetails(Sendinblue http, int id) {
        Map < String, Object > data = new HashMap < String, Object > ();
          data.put("id", id);

        String str = http.get_campaign_v2(data);
        System.out.println(str);
		
	}
	
	private static void createFolder(Sendinblue http, String name){
	Map < String, Object > data = new HashMap < String, Object> ();
	data.put("name", name);

	String str = http.create_folder(data);
	System.out.println(str);
	}
	
	private static void createList(Sendinblue http, String name, int parent){
		 Map < String, Object > data = new HashMap < String, Object > ();
         data.put("list_name", name);
         data.put("list_parent", parent);

       String str = http.create_list(data);
       System.out.println(str);
	}
	
	private static void createCampaign(Sendinblue http){
		//API DOC URL https://apidocs.sendinblue.com/campaign/
		Map < String, Object > data = new HashMap < String, Object > ();
        data.put("category", "Campaña de Bovimax al 50% por enero 2018");
        data.put("from_name", "No-Reply@bovimax.com");
        data.put("name", "¡Bovimax al 50% por enero 2018!");
        //data.put("bat", "");
        data.put("html_content", "<body style=\"margin:0; padding:0;\">Bovimax al 50% Consíguela Ya!!</body>");
        //data.put("html_url", "https://www.bovimax.com");
        data.put("listid", new int [] {2,7});
        //data.put("scheduled_date", "2017-11-27 00:00:01");
        data.put("subject", "¡Promoción Bovimax al 50%!");
        data.put("from_email", "jseagraves@plenumsoft.com.mx");
        //data.put("reply_to", "[DEFAULT_REPLY_TO]");
        //data.put("to_field", "");
        //data.put("exclude_list", new int [] {});
        data.put("attachment_url", "https://www.atlanticadigital.net/images/promociones/50off.png");
        data.put("inline_image", 1);
        data.put("mirror_active", 1);
        data.put("send_now", 1);
        data.put("utm_campaign", "Enero 2018 Bovimax al 50 por ciento");

      String str = http.create_campaign(data);
      System.out.println(str);
	}
	
	private static void importUsers(Sendinblue http, String usuarios, int[] listIds){
		Map < String, Object > data = new HashMap < String, Object > ();
        data.put("body", usuarios);
        data.put("listids", listIds);
        data.put("name", "Lista 1");

      String str = http.import_users(data);
      System.out.println(str);
	}

}
