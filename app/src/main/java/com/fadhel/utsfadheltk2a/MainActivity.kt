package com.fadhel.utsfadheltk2a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() ,AdapterView.OnItemSelectedListener{
    val Spinkotaasal = arrayOf<String>("Padang","Medan")
    val Spinkotatujuan = arrayOf<String>("Jakarta","Bandung")
    lateinit var kotaasal : Spinner
    lateinit var kotatujuan : Spinner
    lateinit var berangkat : DatePicker
    lateinit var dewasa : EditText
    lateinit var anak : EditText
    lateinit var bayi : EditText
    lateinit var chkdewasa : CheckBox
    lateinit var chkanak : CheckBox
    lateinit var chkbayi : CheckBox
    lateinit var kelaspenerbangan : RadioGroup
    lateinit var namapemesanan : EditText
    lateinit var notelp : EditText
    lateinit var hargatiketdewasa : EditText
    lateinit var hargatiketanak : EditText
    lateinit var hargatiketbayi : EditText
    lateinit var pesan : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kotaasal = findViewById(R.id.spinkotaasal)
        kotaasal.onItemSelectedListener=this
        val arrayAdapter : ArrayAdapter<*> = ArrayAdapter<Any?>(this,R.layout.spinner_style , Spinkotaasal)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_style)
        kotaasal.adapter=arrayAdapter

        kotatujuan = findViewById(R.id.spinkotatujuan)
        kotatujuan.onItemSelectedListener=this
        val arrayAdapter1 : ArrayAdapter<*> = ArrayAdapter<Any?>(this,R.layout.spinner_style , Spinkotatujuan)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_style)
        kotatujuan.adapter=arrayAdapter1

        berangkat = findViewById(R.id.dateberangkat)
        val tanggal = Calendar.getInstance()
        val tgl = berangkat.init(
            tanggal.get(Calendar.YEAR),tanggal.get(Calendar.MONTH),tanggal.get(Calendar.DAY_OF_MONTH)){

            tanggal,year,month,day ->
            val month = month+1
            val tanggaldipilih = "$year - $month - $day"
            Toast.makeText(this,"$tanggaldipilih",Toast.LENGTH_SHORT).show()

        dewasa = findViewById(R.id.editdewasa)
        anak = findViewById(R.id.editanak)
        bayi = findViewById(R.id.editbayi)
        chkdewasa = findViewById(R.id.chkdewasa)
        chkanak = findViewById(R.id.chkanak)
        chkbayi = findViewById(R.id.chkbayi)

        kelaspenerbangan = findViewById(R.id.rgkelaspenerbangan)

        namapemesanan = findViewById(R.id.editnamapemesan)
        notelp = findViewById(R.id.editnotelp)
        hargatiketdewasa = findViewById(R.id.edithargatiketdewasa)
        hargatiketanak = findViewById(R.id.edithargatiketanak)
        hargatiketbayi = findViewById(R.id.edithargatiketbayi)
        pesan = findViewById(R.id.btnpesan)

        pesan.setOnClickListener {
            val KotaAsal = kotaasal.selectedItem
            val KotaTujuan = kotatujuan.selectedItem
            val Dewasa = dewasa.text
            val Anak = anak.text
            val Bayi = bayi.text
            val dewasa = chkdewasa.isChecked
            val anak = chkanak.isChecked
            val bayi = chkanak.isChecked

            val kelasPenerbangan = kelaspenerbangan.checkedRadioButtonId
            val Penerbangan = findViewById<RadioButton>(kelasPenerbangan)

            val Namapemesan = namapemesanan.text
            val Notelp = notelp.text
            val Hargatiketdewasa = hargatiketdewasa.text.toString().toDouble()
            val Hargatiketanak = hargatiketanak.text.toString().toDouble()
            val Hargatiketbayi = hargatiketbayi.text.toString().toDouble()

            val bundle = Bundle()
            bundle.putString("kotaasal",KotaAsal.toString())
            bundle.putString("kotatujuan",KotaTujuan.toString())
            bundle.putString("berangkat",tanggaldipilih.toString())
            bundle.putString("jumlahpenumpang",Dewasa.toString())
            bundle.putString("kelaspenerbangan",Penerbangan.text.toString())
            bundle.putString("namapemesan",Namapemesan.toString())
            bundle.putString("notelp",Notelp.toString())
            bundle.putString("hargadewasa",Hargatiketdewasa.toString())
            bundle.putString("hargaanak",Hargatiketanak.toString())
            bundle.putString("hargatiketbayi",Hargatiketbayi.toString())

            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        }
    }










    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val toast : String = p0?.getItemAtPosition(p2).toString()
        Toast.makeText(this,"$toast",Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}