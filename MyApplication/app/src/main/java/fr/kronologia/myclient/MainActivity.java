package fr.kronologia.myclient;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {


    RequestQueue queue;
    TextView myTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);

        myTV = (TextView) findViewById(R.id.text);
        final Button getAllButton = (Button) findViewById(R.id.getAllButton);
        final Button putButton = (Button) findViewById(R.id.addButton);

        getAllButton.setOnClickListener(getAllListener);
        putButton.setOnClickListener(addListener);

// Instantiate the RequestQueue.

        String url ="http://10.21.135.243:8080/myapp/character/51";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        myTV.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myTV.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    View.OnClickListener getAllListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String url = "http://10.21.135.243:8080/myapp/characters";

// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            myTV.setText("Getall : " + response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    myTV.setText("That didn't work!");
                }
            });

            queue.add(stringRequest);
        }
    };

    View.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                final String url = "http://10.21.135.243:8080/myapp/character";
                final JSONObject jsonBody = new JSONObject("{\"name\":\"paul\",\"level\":\"1\"}");

                JsonObjectRequest request = new JsonObjectRequest(url, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        myTV.setText("prout");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("myclient", error.toString());
                        myTV.setText("That didn't work!");
                    }
                });

                queue.add(request);
            } catch(JSONException e) {
                myTV.setText("blabla");

            }
        }
    };
}
