package com.yzw.android.androidimageslider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;


public class MainActivity extends AppCompatActivity {

private static final String TAG="MainActivity";
    private SliderLayout sliderShow;
    private PagerIndicator mIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderShow = (SliderLayout) findViewById(R.id.slider);
        mIndicator= (PagerIndicator) findViewById(R.id.custom_indicator);
        initTextSliderView();
        sliderShow.setCustomIndicator(mIndicator);
       // sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom); //默认的标签
        sliderShow.setPresetTransformer(SliderLayout.Transformer.RotateDown);//设置image转动动画
        sliderShow.setCustomAnimation(new DescriptionAnimation());//设置底部description动画
        sliderShow.setDuration(3000);

        sliderShow.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {


                Log.d(TAG,"onPageScrolled");

            }

            @Override
            public void onPageSelected(int i) {

                Log.d(TAG,"onPageSelected");
            }

            @Override
            public void onPageScrollStateChanged(int i) {

                Log.d(TAG,"onPageScrollStateChanged");
            }
        });
    }

    private void initTextSliderView() {
        TextSliderView textSliderView1 = new TextSliderView(this);
        textSliderView1
                .description("新品推荐")
                .image("http://m.360buyimg.com/mobilecms/s300x98_jfs/t2416/102/20949846/13425/a3027ebc/55e6d1b9Ne6fd6d8f.jpg");

        TextSliderView textSliderView2 = new TextSliderView(this);
        textSliderView2
                .description("时尚男装")
                .image("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1507/64/486775407/55927/d72d78cb/558d2fbaNb3c2f349.jpg");

        TextSliderView textSliderView3 = new TextSliderView(this);
        textSliderView3
                .description("家电秒杀")
                .image("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1363/77/1381395719/60705/ce91ad5c/55dd271aN49efd216.jpg");



        sliderShow.addSlider(textSliderView1);
        sliderShow.addSlider(textSliderView2);
        sliderShow.addSlider(textSliderView3);

        //添加监听
        textSliderView1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(MainActivity.this, "新品推荐", Toast.LENGTH_LONG).show();

            }
        });

        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(MainActivity.this, "时尚男装", Toast.LENGTH_LONG).show();

            }
        });

        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(MainActivity.this, "家电秒杀", Toast.LENGTH_LONG).show();

            }
        });
    }


    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
