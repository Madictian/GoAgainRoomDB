package com.example.goagain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goagain.db.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    private LayoutInflater inflater;
    private List<User> users;

    UserListAdapter(Context context){ inflater = LayoutInflater.from(context);}

    class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView firstname;
        private final TextView lastname;
        private final TextView age;
        private final TextView id;


        private UserViewHolder (View itemView){
            super(itemView);
            firstname = itemView.findViewById(R.id.first_name_txt);
            lastname = itemView.findViewById(R.id.last_name_txt);
            age = itemView.findViewById(R.id.age_txt);
            id = itemView.findViewById(R.id.number_txt);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.layout_recyclerview, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        if(users != null){
            User current = users.get(position);
            holder.firstname.setText(current.getFirstName());
            holder.lastname.setText(current.getLastName());
            holder.age.setText(current.getAge()+"");
            holder.id.setText(current.getId()+"");

        }else {
            holder.firstname.setText("No user");
        }
    }

    void setUsers(List<User> userlist){
        users = userlist;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
       if (users != null){
           return users.size();
       }else {
           return 0;
       }
    }




}
