package com.example.designprofile.profile.root;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.designprofile.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class RootApplication {

    public static void setBackgroundOpacity(View view, int color, float ratio){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.setBackgroundColor(getColorWithAlpha(view.getContext().getColor(color),ratio));
        }
    }

    private static int getColorWithAlpha(int color, float ratio) {
        int newColor = 0;
        int alpha = Math.round(Color.alpha(color) * ratio);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        newColor = Color.argb(alpha, r, g, b);
        return newColor;
    }

    public static void loadImageGif(Context context, Object object, ImageView imageView){
        Glide.with(context)
                .asGif()
                .load(object)
                .into(imageView);
    }

    public static void loadImageCircle(Context context, Object object, ImageView imageView){
        Glide.with(context)
                .load(object)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }

    public static void setFont(Context context, int font, TextView target){
        Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), context.getResources().getString(font)); // dat fonts
        target.setTypeface(myTypeface);
    }

    public static String setDollar(float input){
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        return (NumberFormat.getCurrencyInstance(new Locale("en", "EU")).format(input)).substring(1,
                NumberFormat.getCurrencyInstance(new Locale("en", "EU")).format(input).length());
    }

    public static void setColorImageView(ImageView imageView){
        imageView.setColorFilter(Color.parseColor("#1E1E1E"));
    }
}
