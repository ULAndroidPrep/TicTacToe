package edu.rosehulman.fisher.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private TicTacToeGame mGame;
  private Button[] mButtons;
  private TextView mGameStateTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mGame = new TicTacToeGame(this);
    mGameStateTextView = (TextView)findViewById(R.id.game_state_text_view);
    mButtons = new Button[TicTacToeGame.NUM_SQUARES];
    mButtons[0] = (Button)findViewById(R.id.button0);
    mButtons[1] = (Button)findViewById(R.id.button1);
    mButtons[2] = (Button)findViewById(R.id.button2);
    mButtons[3] = (Button)findViewById(R.id.button3);
    mButtons[4] = (Button)findViewById(R.id.button4);
    mButtons[5] = (Button)findViewById(R.id.button5);
    mButtons[6] = (Button)findViewById(R.id.button6);
    mButtons[7] = (Button)findViewById(R.id.button7);
    mButtons[8] = (Button)findViewById(R.id.button8);

    // Fancy alternative
//    for (int i = 0; i < TicTacToeGame.NUM_SQUARES; i++) {
//        int id = getResources().getIdentifier("button" + i, "id", getPackageName());
//        mButtons[i] = (Button)findViewById(id);
//      }
//    }
  }

  public void pressedSquare(View view) {
    mGame.pressedButtonAtIndex(Integer.valueOf((String) view.getTag()));
    updateView();
  }


  public void pressedNewGame(View view) {
    mGame = new TicTacToeGame(this);
    updateView();
  }

  private void updateView() {
    mGameStateTextView.setText(mGame.stringForGameState());

    for (int i = 0; i < TicTacToeGame.NUM_SQUARES; i++) {
      mButtons[i].setText(mGame.stringForButtonAtIndex(i));
    }
  }

}
