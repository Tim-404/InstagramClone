package com.example.instagramclone.fragments;

import android.util.Log;

import com.example.instagramclone.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostsFragment {

    private static final String TAG = "ProfileFragment";

    @Override
    protected void queryPosts() {
       // Specify which class to query
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        // Specify the object id
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_AT);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> fetchedPosts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }

                for (Post post : fetchedPosts) {
                    Log.i(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser().getUsername());
                }

                posts.addAll(fetchedPosts);
                postsAdapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }
        });
    }
}
