package lube.kare.kengine.util.activityutil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Spanned;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by imac on 15. 11. 24..
 */
public class BaseActivityUtil {

    public String getTextFromEdit(Activity ac, int id) {
        EditText et = (EditText) ac.findViewById(id);
        return et.getText().toString();
    }

    public boolean getBoolFromCheck(Activity ac, int id) {
        CheckBox cb = (CheckBox) ac.findViewById(id);
        return cb.isChecked();
    }

    public int getIntFromCheck(Activity ac, int id) {
        CheckBox cb = (CheckBox) ac.findViewById(id);
        if (cb.isChecked()) return 1;
        else return 0;
//        return cb.isChecked();
    }

    public void setBoolToCheck(Activity ac, int id, boolean check) {
        CheckBox cb = (CheckBox) ac.findViewById(id);
        cb.setChecked(check);
    }

    public CheckBox getCheckBox(Activity ac, int id) {
        CheckBox cb = (CheckBox) ac.findViewById(id);
        return cb;
    }

    public boolean getBoolFromCheck(View view, int id) {
        CheckBox cb = (CheckBox) view.findViewById(id);
        return cb.isChecked();
    }

    public String getTextFromEdit(Activity ac, int id, Boolean isClear) {

        EditText et = (EditText) ac.findViewById(id);
        if (et == null) return "";
        String text = et.getText().toString();
        et.setText("");
        return text;
    }

    public void setTextToTextView(Activity ac, int id, String str) {
        TextView tv = (TextView) ac.findViewById(id);
        tv.setText(str);
    }

    public void setTextToTextView(Activity ac, int id, Spanned str) {
        TextView tv = (TextView) ac.findViewById(id);
        tv.setText(str);
    }
    public void setTextToEdit(Activity ac, int id, String str) {
        EditText et = (EditText) ac.findViewById(id);
        et.setText(str);
    }

    public boolean isSelectCheckbox(Activity ac, int id) {
        CheckBox ck = (CheckBox) ac.findViewById(id);
        return ck.isChecked();
    }



    public void setColorToTextView(Activity ac,int id,String color){

        TextView tv= (TextView) ac.findViewById(id);
        tv.setTextColor(Color.parseColor(color));
    }


    public void setColorToTextView(View view,int id,String color){

        TextView tv= (TextView) view.findViewById(id);
        tv.setTextColor(Color.parseColor(color));
    }


    public String getTextFromEdit(View view, int id) {
        EditText et = (EditText) view.findViewById(id);
        return et.getText().toString();
    }

    public String getTextFromEdit(View view, int id, Boolean isClear) {
        EditText et = (EditText) view.findViewById(id);
        String text = et.getText().toString();
        et.setText("");
        return text;
    }

    public void setTextToTextView(View view, int id, String str) {
        TextView tv = (TextView) view.findViewById(id);
        if (tv == null) return;
        tv.setText(str);
    }

    public void setTextToTextView( TextView tv, String str) {

        if (tv == null) return;
        tv.setText(str);
    }

    public void setTextToEdit(View view, int id, String str) {
        EditText et = (EditText) view.findViewById(id);
        et.setText(str);
    }

    public boolean isSelectCheckbox(View view, int id) {
        CheckBox ck = (CheckBox) view.findViewById(id);
        return ck.isChecked();
    }



    public Bitmap takeScreenShot(Activity activity) {

        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        Bitmap b = Bitmap
                .createBitmap(b1, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

    public Bitmap fastblur(Bitmap sentBitmap, int radius) {
        Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);
        if (radius < 1) {
            return (null);
        }
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int[] pix = new int[w * h];
        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);
        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;
        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];
        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int dv[] = new int[256 * divsum];
        for (i = 0; i < 256 * divsum; i++) {
            dv[i] = (i / divsum);
        }
        yw = yi = 0;
        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;
        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;
            for (x = 0; x < w; x++) {
                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];
                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;
                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];
                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];
                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];
                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;
                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];
                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];
                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];
                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;
                sir = stack[i + radius];
                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];
                rbs = r1 - Math.abs(i);
                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                // Preserve alpha channel: ( 0xff000000 & pix[yi] )
                pix[yi] = (0xff000000 & pix[yi]) | (dv[rsum] << 16) | (dv[gsum] << 8) | dv[bsum];
                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;
                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];
                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];
                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];
                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];
                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];
                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;
                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];
                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];
                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];
                yi += w;
            }
        }
        Log.e("pix", w + " " + h + " " + pix.length);
        bitmap.setPixels(pix, 0, w, 0, 0, w, h);
        return (bitmap);
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    // 설명 날리기 할때 셋팅
    public void visible(Activity ac,int id,int visible){
        ac.findViewById(id).setVisibility(visible);
    }
    public void visible(View view,int id,int visible){
        view.findViewById(id).setVisibility(visible);
    }

    public int dpToPx(int dp, Context context){
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        return px;
    }
    public int pxToDp(float px,Context context) {
        // Get the screen's density scale
        final float scale = context.getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (px * scale + 0.5f);
    }
}
