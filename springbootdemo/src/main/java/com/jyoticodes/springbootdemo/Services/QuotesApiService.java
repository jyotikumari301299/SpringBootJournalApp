// package com.jyoticodes.springbootdemo.Services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.client.RestTemplate;

// import com.jyoticodes.springbootdemo.ApiResponse.QuotesResponse;

// public class QuotesApiService {
//     private static final String  apiKey = "O0dVLJ69S4LWEonaWGOYIjR495IwtS6sHOHg8X3w";

//     private  final String API = "http://quotes.rest/quote/random.json?api_key="+apiKey;
     
//     @Autowired
//     private RestTemplate restTemplate;
    
//     public QuotesResponse getQuotes()
//     {
//        ResponseEntity<QuotesResponse> response = restTemplate.exchange(API,HttpMethod.GET,null,QuotesResponse.class);
//        QuotesResponse body = response.getBody();
//        return body;
//     }

//     public RestTemplate restTemplate2()
//     {
//         return new RestTemplate();
//     }
// }
