package org.example;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        FileWriter myWriter = new FileWriter("descriptions.txt",true);

        String no="100000";

        for (;;) {

            String string = String.format("https://www.linkedin.com/voyager/api/jobs/jobPostings/%s?decorationId=com.linkedin.voyager.deco.jobs.web.shared.WebFullJobPosting-65&topN=1&topNRequestedFlavors=List(TOP_APPLICANT,IN_NETWORK,COMPANY_RECRUIT,SCHOOL_RECRUIT,HIDDEN_GEM,ACTIVELY_HIRING_COMPANY)", no);
            URL url2 = new URL(string);
            HttpURLConnection httpConn2 = (HttpURLConnection) url2.openConnection();
            httpConn2.setRequestMethod("GET");

            httpConn2.setRequestProperty("authority", "www.linkedin.com");
            httpConn2.setRequestProperty("accept", "application/vnd.linkedin.normalized+json+2.1");
            httpConn2.setRequestProperty("accept-language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
            httpConn2.setRequestProperty("cookie", "bcookie=\"v=2&fc5c7edb-7d42-4edc-8093-c2f699ac02c8\"; bscookie=\"v=1&20220818125539bf157901-a9ea-41a6-8eaa-19e4f2aeed50AQGG63uuIw_X2B3JILfoCfDaHo29NzPw\"; g_state={\"i_l\":0}; li_at=AQEDAR-yac8ESXl0AAABgrEHcZgAAAGC1RP1mE4AyrRMvhmoRq2TlAZdk-EKLlnCXT7RCsx__-L-ILerNC2fH3eEGv2XDqvqOmQHHMwAeQa8lvbVU698vLn6OqJ9yIP7dcpozMJIPAheyFVgOXFP_n6W; liap=true; JSESSIONID=\"ajax:4261766337980213203\"; lidc=\"b=VB91:s=V:r=V:a=V:p=V:g=2896:u=329:x=1:i=1660827431:t=1660906041:v=2:sig=AQEdaqnZQnFPTUU7-Y8xNZ7Figu7b8N3\"; lang=v=2&lang=en-us; timezone=Europe/Istanbul; li_theme=light; li_theme_set=app");
            httpConn2.setRequestProperty("csrf-token", "ajax:4261766337980213203");
            httpConn2.setRequestProperty("referer", "https://www.linkedin.com/jobs/search/?currentJobId=3217167045&geoId=92000000&location=Worldwide&refresh=true");
            httpConn2.setRequestProperty("sec-ch-ua", "\"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"104\"");
            httpConn2.setRequestProperty("sec-ch-ua-mobile", "?0");
            httpConn2.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
            httpConn2.setRequestProperty("sec-fetch-dest", "empty");
            httpConn2.setRequestProperty("sec-fetch-mode", "cors");
            httpConn2.setRequestProperty("sec-fetch-site", "same-origin");
            httpConn2.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
            httpConn2.setRequestProperty("x-li-lang", "en_US");
            httpConn2.setRequestProperty("x-li-page-instance", "urn:li:page:d_flagship3_search_srp_jobs;gST4MGxWS3CMGHi23kZ0hw==");
            httpConn2.setRequestProperty("x-li-pem-metadata", "Voyager - Careers - Job Details=job-posting");
            httpConn2.setRequestProperty("x-li-track", "{\"clientVersion\":\"1.10.8914\",\"mpVersion\":\"1.10.8914\",\"osName\":\"web\",\"timezoneOffset\":3,\"timezone\":\"Europe/Istanbul\",\"deviceFormFactor\":\"DESKTOP\",\"mpName\":\"voyager-web\",\"displayDensity\":2,\"displayWidth\":3024,\"displayHeight\":1964}");
            httpConn2.setRequestProperty("x-restli-protocol-version", "2.0.0");

            InputStream responseStream2 = httpConn2.getResponseCode() / 100 == 2
                    ? httpConn2.getInputStream()
                    : httpConn2.getErrorStream();
            Scanner s2 = new Scanner(responseStream2).useDelimiter("\\A");
            String response2 = s2.hasNext() ? s2.next() : "";
            //System.out.println(response2);
            String desc = StringUtils.substringBetween(response2, "],\"text\":\"", "\",\"$type\"");
            //System.out.println(aa);
            String title = StringUtils.substringBetween(response2, ",\"title\":\"", "\",\"skillsDescription\":");
            if (desc != null) {
                myWriter.write("no:" + no + " title:" + title + "\n" + "\n" + desc + "\n" + "\n");
                myWriter.flush();
            }
            System.out.println(no);
            Integer ab = Integer.valueOf(no);
            ab++;
            no = ab.toString();
        }
        /*
        URL url = new URL("https://www.linkedin.com/voyager/api/voyagerJobsDashJobPostingDetailSections?decorationId=com.linkedin.voyager.dash.deco.jobs.FullJobPostingDetailSection-88&cardSectionType=JOB_APPLICANT_INSIGHTS&jobPostingUrn=urn%3Ali%3Afsd_jobPosting%3A3220810415&q=cardSectionType");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");

        httpConn.setRequestProperty("authority", "www.linkedin.com");
        httpConn.setRequestProperty("accept", "application/vnd.linkedin.normalized+json+2.1");
        httpConn.setRequestProperty("accept-language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
        httpConn.setRequestProperty("cookie", "bcookie=\"v=2&fc5c7edb-7d42-4edc-8093-c2f699ac02c8\"; bscookie=\"v=1&20220818125539bf157901-a9ea-41a6-8eaa-19e4f2aeed50AQGG63uuIw_X2B3JILfoCfDaHo29NzPw\"; g_state={\"i_l\":0}; li_at=AQEDAR-yac8ESXl0AAABgrEHcZgAAAGC1RP1mE4AyrRMvhmoRq2TlAZdk-EKLlnCXT7RCsx__-L-ILerNC2fH3eEGv2XDqvqOmQHHMwAeQa8lvbVU698vLn6OqJ9yIP7dcpozMJIPAheyFVgOXFP_n6W; liap=true; JSESSIONID=\"ajax:4261766337980213203\"; lidc=\"b=VB91:s=V:r=V:a=V:p=V:g=2896:u=329:x=1:i=1660827431:t=1660906041:v=2:sig=AQEdaqnZQnFPTUU7-Y8xNZ7Figu7b8N3\"; lang=v=2&lang=en-us; timezone=Europe/Istanbul; li_theme=light; li_theme_set=app");
        httpConn.setRequestProperty("csrf-token", "ajax:4261766337980213203");
        httpConn.setRequestProperty("referer", "https://www.linkedin.com/jobs/search/?currentJobId=3220810415&geoId=92000000&location=Worldwide&refresh=true");
        httpConn.setRequestProperty("sec-ch-ua", "\"Chromium\";v=\"104\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"104\"");
        httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
        httpConn.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
        httpConn.setRequestProperty("sec-fetch-dest", "empty");
        httpConn.setRequestProperty("sec-fetch-mode", "cors");
        httpConn.setRequestProperty("sec-fetch-site", "same-origin");
        httpConn.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
        httpConn.setRequestProperty("x-li-deco-include-micro-schema", "true");
        httpConn.setRequestProperty("x-li-lang", "en_US");
        httpConn.setRequestProperty("x-li-page-instance", "urn:li:page:d_flagship3_search_srp_jobs;cciAeBZUTpqC+l7GSKMEcw==");
        httpConn.setRequestProperty("x-li-track", "{\"clientVersion\":\"1.10.8914\",\"mpVersion\":\"1.10.8914\",\"osName\":\"web\",\"timezoneOffset\":3,\"timezone\":\"Europe/Istanbul\",\"deviceFormFactor\":\"DESKTOP\",\"mpName\":\"voyager-web\",\"displayDensity\":2,\"displayWidth\":3024,\"displayHeight\":1964}");
        httpConn.setRequestProperty("x-restli-protocol-version", "2.0.0");

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        System.out.println(response);

        String a = StringUtils.substringBetween(response, "jobApplicantInsights:", "\"}");
        System.out.println(a);
        */
    }
}