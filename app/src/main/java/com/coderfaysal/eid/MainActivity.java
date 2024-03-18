package com.coderfaysal.eid;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);


        hashMap = new HashMap<>();
        hashMap.put("title", "ঈদ অর্থ কী?");
        hashMap.put("message", "ঈদ অর্থ আনন্দ। এর শাব্দিক অর্থ হলো ‘বারবার ফিরে আসা’ (عَادَ-يَعُوْدُ-عِيْدًا) এ দিনটি বারবার ফিরে আসে বলে এর নামকরণ হয়েছে ঈদ। আল্লাহ তা‘আলা এদিনে তার বান্দাকে নি‘আমাত ও অনুগ্রহ দ্বারা বারবার ধন্য করে থাকেন, বারবার ইহসান করেন। রমযানের পানাহার নিষিদ্ধ করার পর আবার পানাহারের আদেশ প্রদান করেন। ফিত্রা প্রদান ও গ্রহণ, হজ পালন ও কুরবানীর গোশত ভক্ষণ ইত্যাদি নি‘আমাত বছর ঘুরিয়ে তিনি বারবার বান্দাদেরকে ফিরিয়ে দেন। এতে মানুষের প্রাণে আনন্দের সঞ্চার হয়। এসব কারণে এ দিবসের নামকরণ হয়েছে ঈদ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "ঈদের চাদ দেখা ও দোয়া পড়া");
        hashMap.put("message", "اَللهُ اَكْبَرُ اَللَّهُمَّ أَهِلَّهُ عَلَيْنَا بِالْأَمْنِ وَ الْاِيْمَانِ وَالسَّلَامَةِ وَ الْاِسْلَامِ وَ التَّوْفِيْقِ لِمَا تُحِبُّ وَ تَرْضَى رَبُّنَا وَ رَبُّكَ الله\n" +
                "\n" +
                "উচ্চারণ : আল্লাহু আকবার, আল্লাহুম্মা আহিল্লাহু আলাইনা বিল আমনি ওয়াল ঈমানি ওয়াস্সালামাতি ওয়াল ইসলামি ওয়াত্তাওফিকি লিমা তুহিব্বু ওয়া তারদা রাব্বুনা ওয়া রাব্বুকাল্লাহ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "ঈদের শুভেচ্ছা বিনিময়-");
        hashMap.put("message", "ঈদের দিন একে অপরের সঙ্গে সাক্ষাৎ হলে শুভেচ্ছা বিনিময় করা সুন্নত। আর ঈদের শুভেচ্ছা বিনিময় করার সর্বোত্তম পদ্ধতি হলো— এ দোয়া পাঠ করা : \n" +
                "\n" +
                "تقبل الله منا ومنكم \n" +
                "\n" +
                "উচ্চারণ : তাকাব্বালাল্লাহু মিন্না ওয়া মিনকুম। \n" +
                "\n" +
                "অর্থ : আল্লাহ আমাদের ও আপনার পক্ষ থেকে কবুল করুন।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "ঈদ কোন হিজরীতে শুরু হয়?");
        hashMap.put("message", "প্রথম হিজরীতেই ঈদ শুরু হয়। নাবী সাল্লাল্লাহু আলাইহি ওয়াসাল্লাম’র আগের নাবীদের সময় ঈদের প্রচলন ছিল না।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "ঈদের সালাতের হুকুম কী?");
        hashMap.put("message", "ইমাম আবূ হানীফা (রহ.) বলেছেন, ঈদের সালাত প্রত্যেক ব্যক্তির উপর ওয়াজিব। ইমাম ইবনে তাইমিয়্যাহ একই মত পোষণ করেন।");
        arrayList.add(hashMap);


        XAdapter xAdapter = new XAdapter();
        recyclerView.setAdapter(xAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }


    private class XAdapter extends RecyclerView.Adapter<XAdapter.XViewHolder>{


        @NonNull
        @Override
        public XViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.items, parent, false );
            return new XViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull XViewHolder holder, int position) {

            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String message = hashMap.get("message");

            holder.textView.setText(title);

            holder.cardView.setOnClickListener(view -> {
                Details.TITLE = title;
                Details.MESSAGE = message;
                startActivity(new Intent(MainActivity.this, Details.class));
            });


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class XViewHolder extends RecyclerView.ViewHolder{

            TextView textView;
            CardView cardView;

            public XViewHolder(@NonNull View itemView) {
                super(itemView);

                textView = itemView.findViewById(R.id.textView);
                cardView = itemView.findViewById(R.id.cardView);
            }
        }

    }






}