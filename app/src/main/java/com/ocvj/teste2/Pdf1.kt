package com.ocvj.teste2

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import java.io.File
import java.io.FileOutputStream
import android.graphics.DashPathEffect
import android.graphics.RectF
//import com.ocvj.ciclosdesaturno2.GlobalData.Companion.FaseAtual
//import com.ocvj.ciclosdesaturno2.GlobalData.Companion.index1

class Pdf1 : AppCompatActivity() {

    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


/*


        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CODE
            )
        } else {
            generatePDF(this)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                generatePDF(this)
            } else {
                // A permissão foi negada, informe ao usuário que a operação não pode ser concluída
            }
        }
    }
*/
        val pdfDocument = PdfDocument()

            val larguraEmMm = 210f
            val alturaEmMm = 297f

            val pageWidth = 595
            val pageHeight = 842

// Converter de milímetros para pontos (1 ponto = 1/72 polegada)
            val larguraEmPontos = larguraEmMm * 72 / 25.4
            val alturaEmPontos = alturaEmMm * 72 / 25.4

            val pageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()

            val page = pdfDocument.startPage(pageInfo)

            val canvas = page.canvas
            val paint = Paint()

            // Carregue a imagem do recurso em um objeto Bitmap

         //   val bitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.logolea6)

            val xx = 37f
            val yy = 37f
            val h = 16f
            val l = 16
            val hl = 11

            // Tamanho desejado da imagem em mm
            val desiredImageHeightInMm = 20

            // Converter mm para pontos (1mm = 2.83 pontos)
            val desiredImageHeightInPoints = desiredImageHeightInMm * 2.83

            // Calcular a escala para redimensionar a imagem para a altura desejada
        //    val scaleFactor = desiredImageHeightInPoints / bitmap.height

            // Calcular as novas dimensões da imagem
        //    val newImageWidth = bitmap.width * scaleFactor
        //    val newImageHeight = bitmap.height * scaleFactor

            // Define as coordenadas da imagem
            val xCoord = xx+ 28*l
            val yCoord = yy - 2*h + 5f

            paint.color = Color.BLACK
            paint.strokeWidth = 1f
            // Desenhar a imagem no Canvas com a escala adequada

       //     canvas.drawBitmap(bitmap, null, RectF(xCoord, yCoord, xCoord + newImageWidth.toFloat(), yCoord + newImageHeight.toFloat()), paint)


            paint.color = Color.BLACK // Define o contorno (borda) como preto
            paint.strokeWidth = 1f
            paint.style = Paint.Style.STROKE // Define o estilo de pintura como contorno (não preenchido)
            //  paint.alpha = 0 // Define o alfa como 0 (totalmente transparente)
            canvas.drawRect(xx-10f, yy-30f, xx+34*l, yy+70*hl-10f, paint)
            canvas.drawRoundRect(xx+11*l-5f, yy+4*h-30f, xx+33*l+5f, yy+12*h+30f, 10f,10f,paint)

            paint.style = Paint.Style.FILL
            // Configuração de titulo
            paint.color = Color.BLACK
            paint.strokeWidth = 1f
            paint.textSize = 18f
            val titulo = "Ciclos de Saturno"
            canvas.drawText(titulo, xx+11*l, yy*2-30f, paint)

            // Configuração da linha
            paint.color = Color.BLACK
            paint.strokeWidth = 1f
            paint.textSize = 50f

            // três linhas horizontais
            paint.strokeWidth = 1f
            paint.pathEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f) // Define o estilo de traço como pontilhado
            canvas.drawLine(xx+12*l-20f, yy+8*h, xx+15*l+20f, yy+8*h, paint)
            canvas.drawLine(xx+18*l-20f, yy+8*h, xx+21*l+20f, yy+8*h, paint)
            canvas.drawLine(xx+24*l-20f, yy+8*h, xx+26*l+20f, yy+8*h, paint)
            canvas.drawLine(xx+27*l-20f, yy+8*h, xx+32*l+20f, yy+8*h, paint)

            paint.pathEffect = null
            canvas.drawLine(xx+15*l, yy+6*h, xx+16*l, yy+8*h, paint)
            paint.strokeWidth = 3f
            canvas.drawLine(xx+16*l, yy+8*h, xx+17*l, yy+8*h, paint)
            canvas.drawLine(xx+17*l, yy+8*h, xx+19*l, yy+12*h, paint)

            canvas.drawLine(xx+19*l, yy+12*h, xx+20*l, yy+12*h, paint)
            canvas.drawLine(xx+20*l, yy+12*h, xx+22*l, yy+8*h, paint)
            canvas.drawLine(xx+22*l, yy+8*h, xx+23*l, yy+8*h, paint)
            canvas.drawLine(xx+23*l, yy+8*h, xx+25*l, yy+4*h, paint)

            canvas.drawLine(xx+25*l, yy+4*h, xx+26*l, yy+4*h, paint)
            canvas.drawLine(xx+26*l, yy+4*h, xx+28*l, yy+8*h, paint)
            canvas.drawLine(xx+28*l, yy+8*h, xx+29*l, yy+8*h, paint)
            paint.strokeWidth = 1f
            canvas.drawLine(xx+29*l, yy+8*h, xx+30*l, yy+10*h, paint)



            paint.textSize = 7f
            canvas.drawText("Gráfico Padrão", xx+28*l, yy+12*h+20f, paint)

            val dia = 26
            val mes = 6
            var sexo = "M"
          //  val PdfMes = GlobalData.PdfMes
         //   val PdfAno = GlobalData.PdfAno

            val sexoF = "Feminino"
            val sexoM = "Masculino"

            if (sexo == "F") {
                sexo = sexoF
            }else {
                sexo = sexoM
            }
            paint.textSize = 12f
            canvas.drawText("Data: " + dia.toString()+"/"+mes.toString()+" - "+ sexo, xx+10f, yy+7*hl-10f, paint)

            paint.textSize = 9f
            paint.style = Paint.Style.STROKE
            //  canvas.drawRect(xx+11*l-5f, yy+15*h-5f, xx+33*l+5f, yy+46*h+10f, paint)
            canvas.drawRect(xx, yy+15*h-5f, xx+33*l+5f, yy+46*h+10f, paint)


            // divide o texto em linhas com comprimento definido afim de caber no quadro do pdf
            fun quebrarTextoEmLinhas(texto: String, comprimentoMaximo: Int): List<String> {
                val linhas = mutableListOf<String>()
                val palavras = texto.split(" ")

                var linhaAtual = ""
                for (palavra in palavras) {
                    if (linhaAtual.isEmpty()) {
                        linhaAtual = palavra
                    } else {
                        val textoTentativo = "$linhaAtual $palavra"
                        if (textoTentativo.length <= comprimentoMaximo) {
                            linhaAtual = textoTentativo
                        } else {
                            linhas.add(linhaAtual)
                            linhaAtual = palavra
                        }
                    }
                }
                if (linhaAtual.isNotEmpty()) {
                    linhas.add(linhaAtual)
                }
                return linhas
            }

            // função que escreve os textos no quadro do pdf
            fun escreverTextonoCanvas(fase: String, comprimentoLinha: Int) {

                var Tcomeco: String = ""
                var Fcomeco: String = ""
                var Tesperar: String = ""
                var Fesperar: String = ""
                var Tfazer: String = ""
                var Ffazer: String = ""

                val comprimentoMaximo = comprimentoLinha // Define o comprimento máximo desejado
                paint.textSize = 10f

                val Fase = fase
                paint.textSize = 12f

                paint.style = Paint.Style.FILL
                paint.textSize = 10f
                paint.isFakeBoldText = true

                val linhas1 = quebrarTextoEmLinhas(Fcomeco, comprimentoMaximo)
                val linhas2 = quebrarTextoEmLinhas(Fesperar, comprimentoMaximo)
                val linhas3 = quebrarTextoEmLinhas(Ffazer, comprimentoMaximo)

                var linhaY = yy + 16 * h
                var yAtual: Double
                paint.isFakeBoldText = true
                //   canvas.drawText(Tcomeco, xx + 11 * l, linhaY, paint)
                canvas.drawText(Tcomeco, xx+l, linhaY, paint)

                yAtual = linhaY.toDouble() + 20f
                paint.isFakeBoldText = false
                for ((index, linha) in linhas1.withIndex()) {
                    linhaY = yAtual.toFloat() + (index * paint.textSize)
                    canvas.drawText(linha, xx + l, linhaY, paint)
                }

                yAtual += linhas1.size * paint.textSize + 20f
                paint.isFakeBoldText = true
                canvas.drawText(Tesperar, xx + l , yAtual.toFloat(), paint)

                yAtual += 20f
                paint.isFakeBoldText = false
                for ((index, linha) in linhas2.withIndex()) {
                    linhaY = yAtual.toFloat() + (index * paint.textSize)
                    canvas.drawText(linha, xx + l , linhaY, paint)
                }

                yAtual += linhas2.size * paint.textSize + 20f
                paint.isFakeBoldText = true
                canvas.drawText(Tfazer, xx + l , yAtual.toFloat(), paint)

                yAtual += 20f
                paint.isFakeBoldText = false
                for ((index, linha) in linhas3.withIndex()) {
                    linhaY = yAtual.toFloat() + (index * paint.textSize)
                    canvas.drawText(linha, xx + l , linhaY.toFloat(), paint)
                }

            }

            val comprimentoLinha = 90



            pdfDocument.finishPage(page)

            val directory =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val filePath = "${directory}/ciclo_de_Saturno.pdf"

            val file = File(filePath)
            file.createNewFile()

            val fileOutputStream = FileOutputStream(file)
            println("vai escreve o PDF")
            pdfDocument.writeTo(fileOutputStream)
            println("escreveu o pdf")
            pdfDocument.close()
            println("fechou o pdf")

        }
    }

