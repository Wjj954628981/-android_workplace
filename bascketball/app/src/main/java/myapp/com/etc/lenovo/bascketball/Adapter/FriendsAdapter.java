package myapp.com.etc.lenovo.bascketball.Adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import myapp.com.etc.lenovo.bascketball.R;
import myapp.com.etc.lenovo.bascketball.model.FriendsInfo;
import myapp.com.etc.lenovo.bascketball.model.NewsInfo;

public class FriendsAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private Context mContext;
    private List<FriendsInfo> mData; //定义数据源

    //定义构造方法，默认传入上下文和数据源
    public FriendsAdapter(Context context, List<FriendsInfo> data) {
        mContext = context;
        mData = data;
    }


    @Override  //将ItemView渲染进来，创建ViewHolder
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.friends_item, null);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override  //将数据源的数据绑定到相应控件上
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder2 = (MyViewHolder) holder;

        FriendsInfo friendsInfo = mData.get(position);
        holder2.FriendImg.setImageDrawable(mContext.getDrawable(friendsInfo.imgUrl));
        //holder2.FriendImg.getLayoutParams().height = 100; //从数据源中获取图片高度，动态设置到控件上
        holder2.FriendName.setText(friendsInfo.Name);
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder2.itemView.setTag(position);
        ViewCompat.setTransitionName(holder2.FriendName,"News");
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    //定义自己的ViewHolder，将View的控件引用在成员变量上
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView FriendImg;
        public TextView FriendName;

        public MyViewHolder(View itemView) {
            super(itemView);
            FriendImg = (ImageView) itemView.findViewById(R.id.FriendImg);
            FriendName = (TextView) itemView.findViewById(R.id.FriendName);
        }
    }

    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
