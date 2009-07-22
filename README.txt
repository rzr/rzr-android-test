Package: rzr-test-android-imf
Contact: Philippe Coval <philippe.coval@newlc.com>
URL: http://www.newlc.com
Description: Test that show that ImageButton does not change their background in IMF

See video.ogv for sample


Click on the spinner crash :

Thread [<3> main] (Suspended (exception WindowManager$BadTokenException)) 
  ViewRoot.handleMessage(Message) line: 1571  
  ViewRoot(Handler).dispatchMessage(Message) line: 99 
  Looper.loop() line: 123 
  ActivityThread.main(String[]) line: 3948  
  Method.invokeNative(Object, Object[], Class, Class[], Class, int, boolean) line: not available [native method]  
  Method.invoke(Object, Object...) line: 521  
  ZygoteInit$MethodAndArgsCaller.run() line: 782  
  ZygoteInit.main(String[]) line: 540 
  NativeStart.main(String[]) line: not available [native method]  



"Even though the input method window doesn't have explicit focus"

http://android-developers.blogspot.com/2009/04/creating-input-method.html


#eof
