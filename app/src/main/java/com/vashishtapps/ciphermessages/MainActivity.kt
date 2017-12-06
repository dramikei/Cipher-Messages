package com.vashishtapps.ciphermessages

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        encryptBtn.setOnClickListener {
            val txtToEncrypt = encryptField.text.toString()
            val encryptedArray = arrayListOf<Char>()
            var i = 0
            while(i < txtToEncrypt.length) {
                var encryptedChar = ecryptText(txtToEncrypt[i])
                encryptedArray.add(encryptedChar)
                i++

            }
            val encryptedText = encryptedArray.joinToString(separator = "")

            decryptField.setText(encryptedText)

        }

        decryptBtn.setOnClickListener {
            val textToDecrypt = decryptField.text.toString()
            val decryptedArray = arrayListOf<Char>()
            var i = 0
            while (i < textToDecrypt.length) {
                var decryptedChar = decryptText(textToDecrypt[i])
                decryptedArray.add(decryptedChar)
                i++
            }
            val decryptedText = decryptedArray.joinToString(separator = "")
            encryptField.setText(decryptedText)
        }
    }

    fun ecryptText(character: Char): Char {
        val charInt = character.toInt()
        val key = 3
        if (character.isUpperCase()) {
            //
            val alphaVal = charInt - 65
            val newAlphaVal = (alphaVal + key) % 26
            val newAscii = newAlphaVal + 65
            return newAscii.toChar()
        } else if (character.isLowerCase()) {
            val alphaVal = charInt - 97
            val newAlphaVal = (alphaVal + key) % 26
            val newAscii = newAlphaVal + 97
            return newAscii.toChar()
        } else {
            return character
        }
    }

    fun decryptText(character: Char): Char {
        val charInt = character.toInt()
        val key = 3
        if (character.isUpperCase()) {
            //
            val alphaVal = charInt - 65
            val newAlphaVal = (alphaVal - key) % 26
            val newAscii = newAlphaVal + 65
            return newAscii.toChar()
        } else if (character.isLowerCase()) {
            val alphaVal = charInt - 97
            val newAlphaVal = (alphaVal - key) % 26
            val newAscii = newAlphaVal + 97
            return newAscii.toChar()
        } else {
            return character
        }
    }
}
