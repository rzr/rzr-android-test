package fr.online.rzr.test;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;

public class Service extends InputMethodService
{
  View mView;

  @Override
  public View onCreateInputView()
  {
    try
    {
      mView = (View) this.getLayoutInflater().inflate(R.layout.main, null); // TODO:
      this.getCurrentInputConnection().reportFullscreenMode(true);
      // updateFullscreenMode();
      this.getWindow().getWindow().setFlags(
          WindowManager.LayoutParams.FLAG_FULLSCREEN,
          WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
