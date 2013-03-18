package cn.demo.download;  
  
import java.util.List;  
import java.util.Map;  
  
import android.content.Context;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.view.ViewGroup;  
import android.widget.BaseAdapter;  
import android.widget.Button;  
import android.widget.TextView;  
  
  
  
  
public class DownLoadAdapter extends BaseAdapter{  
       
    private LayoutInflater mInflater;  
    private List<Map<String, String>> data;  
    private Context context;  
    private OnClickListener click;  
      
    public DownLoadAdapter(Context context,List<Map<String, String>> data) {  
        this.context=context;  
        mInflater = LayoutInflater.from(context);  
        this.data=data;  
    }  
    public void refresh(List<Map<String, String>> data) {  
        this.data=data;  
        this.notifyDataSetChanged();  
    }  
    public void setOnclick(OnClickListener click) {  
         this.click=click;  
    }  
      
      
    @Override  
    public int getCount() {  
        return data.size();  
    }  
  
    @Override  
    public Object getItem(int position) {  
        return data.get(position);  
    }  
  
    @Override  
    public long getItemId(int position) {  
        return position;  
    }  
  
    @Override  
    public View getView(final int position, View convertView, ViewGroup parent) {  
        final Map<String, String> bean=data.get(position);  
        ViewHolder holder = null;  
        if (convertView == null) {  
            convertView = mInflater.inflate(R.layout.list_item, null);  
            holder = new ViewHolder();   
            holder.resouceName=(TextView) convertView.findViewById(R.id.tv_resouce_name);  
            holder.startDownload=(Button) convertView.findViewById(R.id.btn_start);  
            holder.pauseDownload=(Button) convertView.findViewById(R.id.btn_pause);  
            convertView.setTag(holder);  
        } else {  
            holder = (ViewHolder) convertView.getTag();  
        }   
        holder.resouceName.setText(bean.get("name"));   
        return convertView;  
    }  
    public OnClickListener getClick() {  
        return click;  
    }  
    public void setClick(OnClickListener click) {  
        this.click = click;  
    }  
    private class ViewHolder {   
        public TextView resouceName;  
        public Button startDownload;  
        public Button pauseDownload;  
        
          
       
    }  
      
}  