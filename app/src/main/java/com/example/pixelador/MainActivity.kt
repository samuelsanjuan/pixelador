package com.example.pixelador

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.graphics.scale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagen:ImageView=findViewById(R.id.imagen)
        val minimizar: Button=findViewById(R.id.minimizar)
        val pixelar:Button=findViewById(R.id.pixelar)
        val normal:Button=findViewById(R.id.normal)
        val aumentar:Button=findViewById(R.id.aumentar)

        val options =BitmapFactory.Options()
        options.inSampleSize=1
        options.inMutable=true

        var imagenBitmap=BitmapFactory.decodeResource(resources,R.drawable.zenitsu,options)

        val ancho=imagenBitmap.width
        val alto=imagenBitmap.height



        minimizar.setOnClickListener(){
            options.inSampleSize*=2
            imagenBitmap=BitmapFactory.decodeResource(resources,R.drawable.zenitsu,options)
            imagen.setImageBitmap(imagenBitmap)
            imagen.setImageBitmap(imagenBitmap.scale(1200,600))
        }

        aumentar.setOnClickListener(){
            if (options.inSampleSize>1){
               options.inSampleSize/=2
                imagenBitmap=BitmapFactory.decodeResource(resources,R.drawable.zenitsu,options)
                imagen.setImageBitmap(imagenBitmap)
                imagen.setImageBitmap(imagenBitmap.scale(1200,600))
            }
        }


        normal.setOnClickListener(){
            options.inSampleSize=1
            imagenBitmap=BitmapFactory.decodeResource(resources,R.drawable.zenitsu,options)
            imagen.setImageResource(R.drawable.zenitsu)
        }

        var anchoX:Int
        var altoY:Int

        pixelar.setOnClickListener(){
            for (x in 0..ancho/16-1){
                for (y in 0..alto/16-1){

                    anchoX=x*16
                    altoY=y*16
                    var c=imagenBitmap.getPixel(anchoX, altoY)

                    var colores:IntArray=intArrayOf(c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c)

                            if (anchoX+16<ancho&&altoY+16<alto) {
                        imagenBitmap.setPixels(colores,0,16,anchoX,altoY,16,16)
                    }
                }
            }

            imagen.setImageBitmap(imagenBitmap.scale(1200, 600))
        }
    }
}