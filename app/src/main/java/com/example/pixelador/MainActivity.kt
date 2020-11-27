package com.example.pixelador

import android.graphics.BitmapFactory
import android.graphics.Color
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
        val prueba:Button=findViewById(R.id.pruebas)

        val options =BitmapFactory.Options()
        options.inSampleSize=1
        options.inMutable=true

        var imagenBitmap=BitmapFactory.decodeResource(resources,R.drawable.zenitsu,options)


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
            for (x in 0..imagenBitmap.width/32-1){
                for (y in 0..imagenBitmap.height/32-1){

                    anchoX=x*32
                    altoY=y*32
                    var c=imagenBitmap.getPixel(anchoX, altoY)

                    var colores:IntArray=intArrayOf(c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,
                            c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c)

                        imagenBitmap.setPixels(colores,0,32,anchoX,altoY,32,32)
                }
            }

            imagen.setImageBitmap(imagenBitmap.scale(1200, 600))
        }

        prueba.setOnClickListener(){

            var colorFinal=0
            var colores=ArrayList<Int>()
            var coloresArray :IntArray
            for (x in 0..imagenBitmap.width/32-1){
                for (y in 0..imagenBitmap.height/32-1){
                    for (x0 in 0..x){
                        for (y0 in 0..y){
                            var colorInt=imagenBitmap.getPixel(x0,y0)
                            colorFinal+=colorInt
                        }
                    }
                    colorFinal=colorFinal/(32*32)

                    colores.add(colorFinal)


                }
            }
             coloresArray=colores.toIntArray()
            println(colores.toString())
            imagenBitmap.setPixels(coloresArray,0,32,0,0,32,32)
        }
    }
}