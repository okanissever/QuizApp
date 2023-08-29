package com.example.quizapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import com.example.quizapp.R
import com.example.quizapp.common.viewBinding
import com.example.quizapp.databinding.FragmentHomeBinding
import com.example.quizapp.model.Question
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.a1LVL.setOnClickListener {
            loadQuestions("A1",it)
        }

        binding.a2LVL.setOnClickListener {
            loadQuestions("A2",it)
        }

        binding.b1LVL.setOnClickListener {
            loadQuestions("B1",it)
        }

        binding.b2LVL.setOnClickListener {
            loadQuestions("B2",it)
        }


    }

    private fun loadQuestions(level: String, view: View) {

        val action = HomeFragmentDirections.actionHomeFragmentToQuestionFragment(level)
        Navigation.findNavController(view).navigate(action)
    }


     /*fun addQuestions() {
        val db = Firebase.firestore

         val additionalQuestionsSetB2_4 = mutableListOf(
             Question("grievance", "şikayet", "dekorasyon", "biçim", "takip", "şikayet"),
             Question("harmonize", "orijin", "ışık", "uyumlaştırmak", "özet", "uyumlaştırmak"),
             Question("intrinsic", "teknoloji", "ürün", "sürücü", "özgün", "özgün"),
             Question("juxtapose", "yan yana koymak", "çizgi", "dikim", "çaba", "yan yana koymak"),
             Question("knack", "örümcek", "beceri", "örümcek", "kurgu", "beceri"),
             Question("litigate", "dava açmak", "rezerv", "tutar", "ölçek", "dava açmak"),
             Question("magnify", "kılavuz", "tasarım", "büyütmek", "parlamento", "büyütmek"),
             Question("nostalgia", "önerme", "elektromanyetik", "evrensel", "özlem", "özlem"),
             Question("omniscient", "herşeyi bilen", "ters", "aktarım", "koalisyon", "herşeyi bilen"),
             Question("prolific", "derinlik", "olgu", "verimli", "işlem", "verimli")
         )

         val additionalQuestionsSetB2_5 = mutableListOf(
             Question("quintessential", "tam anlamıyla öz", "parantez", "genel", "kapsam", "tam anlamıyla öz"),
             Question("reiterate", "yanıt", "merkez", "tekrarlamak", "tezgah", "tekrarlamak"),
             Question("substantiate", "dinamik", "kavram", "doğrulamak", "parti", "doğrulamak"),
             Question("trivialize", "önemsiz göstermek", "bilim", "segment", "topluluk", "önemsiz göstermek"),
             Question("ubiquitous", "her yerde bulunan", "motor", "analiz", "bilinç", "her yerde bulunan"),
             Question("vex", "işaret", "diyagram", "sinirlendirmek", "izlenim", "sinirlendirmek"),
             Question("wield", "strateji", "bakış açısı", "formül", "kullanmak", "kullanmak"),
             Question("xenophobic", "yabancı düşmanı", "teori", "paradoks", "farkındalık", "yabancı düşmanı"),
             Question("yield", "üretmek", "bakım", "bağlantı", "örnek", "üretmek"),
             Question("zealot", "algı", "varlık", "fanatik", "yüzde", "fanatik")
         )

         val additionalQuestionsSetB2_6 = mutableListOf(
             Question("allege", "iddia etmek", "fonksiyon", "başlık", "denge", "iddia etmek"),
             Question("brevity", "gelişim", "karakter", "kısalık", "taktik", "kısalık"),
             Question("construe", "devrim", "kontekst", "yorumlamak", "elektron", "yorumlamak"),
             Question("dissipate", "zorlanmak", "hipotez", "dağıtmak", "spor", "dağıtmak"),
             Question("endeavor", "çaba", "dinamit", "dizi", "felsefe", "çaba"),
             Question("fathom", "mekanizma", "prototip", "kavramak", "anlam", "kavramak"),
             Question("genuflect", "diz çökmek", "sistematik", "analiz", "bölüm", "diz çökmek"),
             Question("haphazard", "sonuç", "periyodik", "başlık", "rastgele", "rastgele"),
             Question("imbibe", "doku", "çıkarım", "içmek", "gerçeklik", "içmek"),
             Question("jettison", "görünüş", "evrimsel", "atmak", "özellik", "atmak")
         )


        for (question in additionalQuestionsSetB2_4) {
            db.collection("Questions").document("B2").collection("question4").add(question)
                .addOnSuccessListener { documentReference ->
                    Log.d("Question", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("Question", "Error adding document", e)
                }
        }

         for (question in additionalQuestionsSetB2_5) {
             db.collection("Questions").document("B2").collection("question5").add(question)
                 .addOnSuccessListener { documentReference ->
                     Log.d("Question", "DocumentSnapshot added with ID: ${documentReference.id}")
                 }
                 .addOnFailureListener { e ->
                     Log.w("Question", "Error adding document", e)
                 }
         }

         for (question in additionalQuestionsSetB2_6) {
             db.collection("Questions").document("B2").collection("question6").add(question)
                 .addOnSuccessListener { documentReference ->
                     Log.d("Question", "DocumentSnapshot added with ID: ${documentReference.id}")
                 }
                 .addOnFailureListener { e ->
                     Log.w("Question", "Error adding document", e)
                 }
         }

    }*/

}