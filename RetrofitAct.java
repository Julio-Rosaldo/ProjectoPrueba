package com.example.apirest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.apirest.interfaces.JsonPlaceholderApi;
import com.example.apirest.models.Photo;
import com.example.apirest.models.Post;
import com.example.apirest.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAct extends AppCompatActivity {

    private TextView TxtJSON;
    private ImageView ImgJSON;

    private Retrofit retrofit;
    private JsonPlaceholderApi jsonPlaceholderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        TxtJSON = findViewById(R.id.txtJson);
        TxtJSON.setText("");
        ImgJSON = findViewById(R.id.imgJson);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);

        //getPosts();
        //getUsers();
        //findUser();
        findPhoto();

        //createPost();
        //putPost();
        //deletePost();
    }

    private void getPosts() {
        Call<List<Post>> call = jsonPlaceholderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()){
                    List<Post> listPosts = response.body();
                    for (Post post : listPosts){
                        String content = "";
                        content += post.getUserId() + "\n";
                        content += post.getId() + "\n";
                        content += post.getTitle() + "\n";
                        content += post.getBody() + "\n";
                        content += "\n";
                        TxtJSON.append(content);
                        //String ImgURL = "http://192.168.2.117/img/" + producto.getPro_codigo() + ".jpg";
                        //Glide.with(getApplication()).load(ImgURL).into(ImgProducto);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getUsers() {
        Call<List<User>> call = jsonPlaceholderApi.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    List<User> list = response.body();
                    for (int i = 0; i < list.size(); i++){
                        String content = "";
                        content += list.get(i).getId() + "\n";
                        content += list.get(i).getName() + "\n";
                        content += list.get(i).getUsername() + "\n";
                        content += list.get(i).getEmail() + "\n";
                        content += list.get(i).getAddress().getStreet() + "\n";
                        content += list.get(i).getAddress().getSuite() + "\n";
                        content += list.get(i).getAddress().getCity() + "\n";
                        content += list.get(i).getAddress().getZipcode() + "\n";
                        content += list.get(i).getAddress().getGeo().getLat() + "\n";
                        content += list.get(i).getAddress().getGeo().getLng() + "\n";
                        content += list.get(i).getPhone() + "\n";
                        content += list.get(i).getWebsite() + "\n";
                        content += list.get(i).getCompany().getName() + "\n";
                        content += list.get(i).getCompany().getCatchPhrase() + "\n";
                        content += list.get(i).getCompany().getBs() + "\n";
                        content += "\n";
                        TxtJSON.append(content);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void findUser() {
        String myid = "1";
        Call<User> call = jsonPlaceholderApi.findUser(myid);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    User user = response.body();
                    //for (int i = 0; i < list.size(); i++){
                        String content = "";
                        content += user.getId() + "\n";
                        content += user.getName() + "\n";
                        content += user.getUsername() + "\n";
                        content += user.getEmail() + "\n";
                        content += user.getAddress().getStreet() + "\n";
                        content += user.getAddress().getSuite() + "\n";
                        content += user.getAddress().getCity() + "\n";
                        content += user.getAddress().getZipcode() + "\n";
                        content += user.getAddress().getGeo().getLat() + "\n";
                        content += user.getAddress().getGeo().getLng() + "\n";
                        content += user.getPhone() + "\n";
                        content += user.getWebsite() + "\n";
                        content += user.getCompany().getName() + "\n";
                        content += user.getCompany().getCatchPhrase() + "\n";
                        content += user.getCompany().getBs() + "\n";
                        content += "\n";
                        TxtJSON.append(content);
                    //}
                }
                else{
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void findPhoto(){
        String myid = "1";
        Call<Photo> call = jsonPlaceholderApi.findPhoto(myid);
        call.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                if (response.isSuccessful()){
                    Photo photo = response.body();
                    //for (int i = 0; i < list.size(); i++){
                    String content = "";
                    content += photo.getAlbumId() + "\n";
                    content += photo.getId() + "\n";
                    content += photo.getTitle() + "\n";
                    content += photo.getUrl() + "\n";
                    content += photo.getThumbnailUrl() + "\n";
                    TxtJSON.append(content);

                    String ImgURL = photo.getUrl() + ".png";
                    Glide.with(getApplication()).load(ImgURL).into(ImgJSON);

                    /*
                    Glide.with(RetrofitAct.this)
                            .load(ImgURL)
                            .apply(new RequestOptions()
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .centerCrop()
                                    .dontAnimate()
                                    .dontTransform())
                            .into(ImgJSON);*/
                }
                else{
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createPost(){
        /*
        Posts post = new Posts(121, "Timucuy", "Pueblito de fiestas y tortolitas");
        Call<Posts> call = jsonPlaceholderApi.createPost(post);
        */

        //Call<Posts> call = jsonPlaceholderApi.createPost(123, "Merida", "Ciudad blanca");

        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "135");
        fields.put("title", "Progeso");
        fields.put("body", "Malecon de progreso");
        Call<Post> call = jsonPlaceholderApi.createPost(fields);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Post postResponse = response.body();
                    String content = "";
                    content += postResponse.getUserId() + "\n";
                    content += postResponse.getId() + "\n";
                    content += postResponse.getTitle() + "\n";
                    content += postResponse.getBody() + "\n";
                    content += "\n";
                    TxtJSON.append(content);
                }
                else{
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void putPost(){
        Post post = new Post(12, null, "Mi texto");
        post.setId(5);

        //Call<Posts> call = jsonPlaceholderApi.putPost(5, post);
        Call<Post> call = jsonPlaceholderApi.patchPost(5, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Post postResponse = response.body();
                    String content = "";
                    content += "userId: " + postResponse.getUserId() + "\n";
                    content += "id: " + postResponse.getId() + "\n";
                    content += "title: " + postResponse.getTitle() + "\n";
                    content += "body: " + postResponse.getBody() + "\n";
                    content += "\n";
                    TxtJSON.append(content);
                }
                else{
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void deletePost(){
        Call<Void> call = jsonPlaceholderApi.deletePost(205);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Eliminacion exitosa", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}