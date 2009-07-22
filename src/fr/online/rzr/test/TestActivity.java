package fr.online.rzr.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class TestActivity extends Activity
{
  public static void initView(Window view)
  {
    assert (view != null);
    Button b = (Button) view.findViewById(R.id.ButtonTest);
    assert (b != null);
    b.setOnClickListener(new OnClickListener()
    {
      public void onClick(View arg)
      {
        CharSequence title = "clicked";
        ((Button) arg).setText(title);
        int i = 0;
      }
    });
    {
      Spinner s = (Spinner) view.findViewById(R.id.spinner);
      ArrayAdapter adapter = ArrayAdapter.createFromResource(view.getContext(),
          android.R.array.imProtocols, android.R.layout.simple_spinner_item);
      adapter
          .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      s.setAdapter(adapter);
    }
  }

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    initView(this.getWindow());
  }
}