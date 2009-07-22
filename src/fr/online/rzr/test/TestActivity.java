package fr.online.rzr.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class TestActivity extends Activity
{
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    {
      setContentView(R.layout.main);
      ImageButton b = (ImageButton) this.findViewById(R.id.ButtonTest);
      b.setOnClickListener(new OnClickListener()
      {
        public void onClick(View arg)
        {
          int i = 0;
        }
      });
    }
  }
}