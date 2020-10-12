package com.example.rps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rock_button.setOnClickListener {
            setWinnerAndLooser("ROCK", getPlayerTwoChoice())
        }

        scissor_button.setOnClickListener {
            setWinnerAndLooser("SCISSOR", getPlayerTwoChoice())
        }

        paper_button.setOnClickListener {
            setWinnerAndLooser("PAPER", getPlayerTwoChoice())
        }
    }

    fun getPlayerTwoChoice(): String {
        var playerTwoChoice = ""

        val randomNumber = (0..2).random()

        if (randomNumber == 0) {
            playerTwoChoice = "ROCK"
        } else if (randomNumber == 1) {
            playerTwoChoice = "SCISSOR"
        } else {
            playerTwoChoice = "PAPER"
        }

        return playerTwoChoice
    }

    fun setWinnerAndLooser(playerOneChoice: String, playerTwoChoice: String) {
        player_one_choise_textView.text = playerOneChoice
        player_two_choise_textView.text = playerTwoChoice

        if(playerOneChoice == "ROCK"){
            if(playerTwoChoice == "ROCK"){
                //tie
                winner_textView.text = "It's a tie..."
            }else if(playerTwoChoice == "SCISSOR"){
                //Player one WON
                winner_textView.text = "You WON!!!"
            }else if (playerTwoChoice == "PAPER"){
                //Player two WON
                winner_textView.text = "Player two won"
            }
        } else if(playerOneChoice == "SCISSOR"){
            if(playerTwoChoice == "SCISSOR"){
                //tie
                winner_textView.text = "It's a tie..."
            }else if (playerTwoChoice == "ROCK"){
                //PLayer two won
                winner_textView.text = "Player two won"
            }else if(playerTwoChoice == "PAPER") {
                //Player one won
                winner_textView.text = "You WON!!!"
            }
        }else if(playerOneChoice == "PAPER"){
            if(playerTwoChoice == "PAPER"){
                //tie
                winner_textView.text = "It's a tie..."
            }else if (playerTwoChoice == "ROCK"){
                //Player one won
                winner_textView.text = "You WON!!!"
            } else if (playerTwoChoice == "SCISSOR"){
                //Player two won
                winner_textView.text = "Player two won"
            }
        }
    }
}