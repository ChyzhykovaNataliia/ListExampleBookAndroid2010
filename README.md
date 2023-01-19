# ListExampleBookAndroid2010
Example list with adapter implementation in different ways (Book Android 2010)
1.StaticDemoActivity list with adapter with same ImageView and TextView
2.DynamicDemoActivity list with adapter in inernal class with implementation method getView(), 
getCount(), getItem(), getItemId().ImageView is change and every time we create new row for every view.
It is too long and take up a lot of memory.
3.RateListDemoActivity list with adapter and RowModel in separate class. In this case in method
getView create View for screen + 2 and then we rewrite them.This speeds up the work.
Also in this case we use ViewWrapper(holder), into which we carried method findViewById and call it only first
one time. That speeds up work. We attach and get to the row with method setTag and getTag.
