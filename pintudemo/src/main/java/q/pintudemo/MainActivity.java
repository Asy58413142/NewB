package q.pintudemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private GridLayout container;
    private ImageView[][] imageViews = new ImageView[4][5];
    private ImageView nullImageView;
    private GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (GridLayout) findViewById(R.id.container);
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.background)).getBitmap();
        int width = bitmap.getWidth() / 5;
        for (int i = 0; i < imageViews.length; i++) {
            for (int j = 0; j < imageViews[0].length; j++) {
                Bitmap bm = Bitmap.createBitmap(bitmap, j * width, i * width, width, width);
                imageViews[i][j] = new ImageView(this);
                imageViews[i][j].setImageBitmap(bm);
                imageViews[i][j].setPadding(2, 2, 2, 2);
                imageViews[i][j].setTag(new GameData(i, j, bm));
                imageViews[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isHas((ImageView) v)) {
                            changeDataByImageView((ImageView) v);
                        }

                    }
                });
            }
        }
        for (int i = 0; i < imageViews.length; i++) {
            for (int j = 0; j < imageViews[0].length; j++) {
                container.addView(imageViews[i][j]);
            }
        }
        setNullImageView(imageViews[imageViews.length - 1][imageViews[0].length - 1]);
        gestureDetector=new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                int type = changeTouch(e1.getX(), e1.getY(), e2.getX(), e2.getY());
                Log.d("onFling: ","==============="+type);
                changeDataByTouch(type);
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    //设置空方块
    public void setNullImageView(ImageView imageView) {

        imageView.setImageBitmap(null);
        nullImageView = imageView;

    }
    //通过手势改变数据
    public void changeDataByTouch(int type) {
        GameData nullImageViewTag = (GameData) nullImageView.getTag();
        int new_x = nullImageViewTag.x;
        int new_y = nullImageViewTag.y;

        switch (type) {
            case 1://要移动的方块在空方块右面  往左滑
                new_y++;
                break;
            case 2://要移动的方块在空方块左面  往右滑
                new_y--;
                break;
            case 3://下
                new_x++;
                break;
            case 4://上
                new_x--;
                break;
        }
        if (new_x >= 0 && new_x < imageViews.length && new_y >= 0 && new_y <imageViews[0].length) {
            changeDataByImageView(imageViews[new_x][new_y]);
        } else {
            //什么也不做
        }
    }
    //获取手势
    public int changeTouch(float startX, float startY, float endX, float endY) {
        boolean isLeftOrRight = (Math.abs(startX - endX) > Math.abs(startY - endY)) ? true : false;
        if (isLeftOrRight) {//左右
            boolean isLeft = startX >endX ? true : false;
            if (isLeft) {
                return 1;//左
            } else {
                return 2;//右
            }
        } else {//上下
            boolean isTop= startY > endY ? true : false;
            if (isTop) {
                return 3;//上
            } else {
                return 4;//下
            }
        }
    }
    //交换两个位置的数据
    public void changeDataByImageView(final ImageView imageView) {
        TranslateAnimation animation=null;
        if (imageView.getX() > nullImageView.getX()) { //点击的方块在空方下边，往上移动
            animation = new TranslateAnimation(0.1f,-imageView.getWidth() , 0.1f, 0.1f);
        }else if (imageView.getX() < nullImageView.getX()) { //点击的方块在空方上边，往下移动
            animation = new TranslateAnimation(0.1f,imageView.getWidth() , 0.1f, 0.1f);
        }else if (imageView.getY() > nullImageView.getY()) { //点击的方块在空方右边，往左移动
            animation = new TranslateAnimation(0.1f,0.1f , 0.1f,-imageView.getWidth());
        }else if (imageView.getY() < nullImageView.getY()) { //点击的方块在空方左边，往右移动
            animation = new TranslateAnimation(0.1f,0.1f , 0.1f,imageView.getWidth());
        }
        animation.setDuration(70);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.clearAnimation();
                GameData imageTag = (GameData) imageView.getTag();
                nullImageView.setImageBitmap(imageTag.bitmap);
                GameData nullImageViewTag = (GameData) nullImageView.getTag();
                nullImageViewTag.bitmap = imageTag.bitmap;
                nullImageViewTag.p_x = imageTag.p_x;
                nullImageViewTag.p_y = imageTag.p_y;
                setNullImageView(imageView);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(animation);
    }
    //判断是不是和空方块有关系
    public boolean isHas(ImageView imageView) {
        GameData imageViewTag = (GameData) imageView.getTag();
        GameData nullImageViewTag = (GameData) nullImageView.getTag();
        if (imageViewTag.x+1 == nullImageViewTag.x && imageViewTag.y == nullImageViewTag.y) {//上边
            Log.d("onClick: ",":==========上边");
            return true;
        } else if (imageViewTag.x-1 == nullImageViewTag.x && imageViewTag.y  == nullImageViewTag.y) {//下边
            Log.d("onClick: ",":==========下边");
            return true;
        } else if (imageViewTag.x== nullImageViewTag.x && imageViewTag.y+1  == nullImageViewTag.y) {//左边
            Log.d("onClick: ",":==========左边");
            return true;
        } else if (imageViewTag.x == nullImageViewTag.x && imageViewTag.y-1  == nullImageViewTag.y) {//右边
            Log.d("onClick: ",":==========右边");
            return true;
        }
        return false;
    }

    class GameData {
        private int x;
        private int y;
        private Bitmap bitmap;
        private int p_x;
        private int p_y;

        public GameData(int x, int y, Bitmap bitmap) {
            this.x = x;
            this.y = y;
            this.bitmap = bitmap;
            this.p_x = x;
            this.p_y = y;
        }
    }
}
