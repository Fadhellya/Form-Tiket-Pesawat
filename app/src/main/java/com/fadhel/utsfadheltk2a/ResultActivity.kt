package com.fadhel.utsfadheltk2a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var kotaasal : TextView
    lateinit var kotatujuan : TextView
    lateinit var berangkat : TextView
    lateinit var jumlahpenumpang : TextView
    lateinit var kelaspenerbangan : TextView
    lateinit var namapemesan : TextView
    lateinit var notelp : TextView
    lateinit var hargatiketdewasa : TextView
    lateinit var hargatiketanak : TextView
    lateinit var hargatiketbayi : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        kotaasal = findViewById(R.id.outkotaasal)
        kotatujuan = findViewById(R.id.outkotatujuan)
        berangkat = findViewById(R.id.outberangkat)
        jumlahpenumpang = findViewById(R.id.outjumlahpenumpang)
        kelaspenerbangan = findViewById(R.id.outkelaspenerbangan)
        namapemesan = findViewById(R.id.outnamapemesan)
        notelp = findViewById(R.id.outnotelp)
        hargatiketdewasa = findViewById(R.id.outhargatiketdewasa)
        hargatiketanak = findViewById(R.id.outhargatiketanak)
        hargatiketbayi = findViewById(R.id.outhargatiketbayi)
        val bundle = intent.extras
        if(bundle!= null){
            kotaasal.text = "Kota Asal : ${bundle.getString("kotaasal")}"
            kotatujuan.text = "Kota Tujuan : ${bundle.getString("kotatujuan")}"
            berangkat.text = "Keberangkatan  : ${bundle.getString("berangkat")}"
            //jumlahpenumpang.text = "Jumlah Penumpang : ${bundle.getString("jumlahpenumpang")}"
            kelaspenerbangan.text = "Kelas Penerbangan : ${bundle.getString("kelaspenerbangan")}"
            namapemesan.text = "Nama Pemesan : ${bundle.getString("namapemesan")}"
            notelp.text = "No Telp : ${bundle.getString("notelp")}"
            hargatiketdewasa.text = "Harga Tiket Dewasa : ${bundle.getString("hargadewasa")}"
            hargatiketanak.text = "Harga Tiket Anak : ${bundle.getString("hargaanak")}"
            hargatiketbayi.text = "Harga Tiket Bayi : ${bundle.getString("hargatiketbayi")}"
        }

    }
}