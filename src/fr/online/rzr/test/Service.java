package fr.online.rzr.test;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Service extends InputMethodService
{
  View mView;

  public static void initView(View view)
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
        arg.requestFocus();
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

  @Override
  public View onCreateInputView()
  {
    try
    {
      mView = (View) this.getLayoutInflater().inflate(R.layout.main, null); // TODO:
      Window window = this.getWindow().getWindow();
      this.initView(mView);
      this.getCurrentInputConnection().reportFullscreenMode(true);
      // updateFullscreenMode();
      this.getWindow().getWindow().setFlags(
          WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE,
          WindowManager.LayoutParams.FLAG_FULLSCREEN);
      mView.requestFocus();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return mView;
  }

  @Override
  public void onStartInputView(EditorInfo info, boolean restarting)
  {
    super.onStartInputView(info, restarting);
    ((View) mView).setVisibility(View.VISIBLE);
  }
}
