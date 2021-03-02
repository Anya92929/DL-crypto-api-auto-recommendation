package com.tapcrowd.app.modules.news;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.utils.twitter.TwitterDialog;
import com.tapcrowd.app.utils.twitter.TwitterPostDialog;
import com.tapcrowd.app.utils.twitter.TwitterV11;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.cordova.Globalization;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.User;

public class TwitterDetailFragment extends TCFragment {
    TextView date;
    AlertDialog.Builder dialog;
    ImageView favorite;
    public View.OnClickListener favoriteClick = new View.OnClickListener() {
        public void onClick(final View v) {
            if (TwitterDetailFragment.this.twitter == null) {
                new TwitterV11(TwitterDetailFragment.this.getActivity(), new TwitterDialog.OnLoginListener() {
                    public void onLogin(Twitter twitter) {
                        TwitterDetailFragment.this.twitter = twitter;
                        TwitterDetailFragment.this.doFavorite(v);
                    }

                    public void onError() {
                        TwitterDetailFragment.this.dialog.setMessage(TwitterDetailFragment.this.getString(C0846R.string.nointernetanddb));
                        TwitterDetailFragment.this.dialog.show();
                    }
                }).login(true);
            } else {
                TwitterDetailFragment.this.doFavorite(v);
            }
        }
    };
    ImageView icon;

    /* renamed from: id */
    String f2088id;
    String imgurl;
    TwitterDialog.OnLoginListener listener = new TwitterDialog.OnLoginListener() {
        public void onLogin(Twitter twitter) {
            TwitterDetailFragment.this.twitter = twitter;
            new getStatusTask(TwitterDetailFragment.this, (getStatusTask) null).execute(new Void[0]);
        }

        public void onError() {
            TwitterDetailFragment.this.showIntent();
        }
    };
    ImageView media;
    TextView message;
    TextView name;
    String nametxt;
    TextView numRetweets;
    ImageView reply;
    public View.OnClickListener replyClick = new View.OnClickListener() {
        public void onClick(View v) {
            if (TwitterDetailFragment.this.twitter == null) {
                new TwitterV11(TwitterDetailFragment.this.getActivity(), new TwitterDialog.OnLoginListener() {
                    public void onLogin(Twitter twitter) {
                        TwitterDetailFragment.this.twitter = twitter;
                        new TwitterPostDialog(TwitterDetailFragment.this.getActivity(), twitter, (String) null, TwitterDetailFragment.this.screennameStr).show();
                    }

                    public void onError() {
                        TwitterDetailFragment.this.dialog.setMessage(TwitterDetailFragment.this.getString(C0846R.string.nointernetanddb));
                        TwitterDetailFragment.this.dialog.show();
                    }
                }).login(true);
            } else {
                new TwitterPostDialog(TwitterDetailFragment.this.getActivity(), TwitterDetailFragment.this.twitter, (String) null, TwitterDetailFragment.this.screennameStr).show();
            }
        }
    };
    ImageView retweet;
    public View.OnClickListener retweetClick = new View.OnClickListener() {
        public void onClick(final View v) {
            if (TwitterDetailFragment.this.twitter == null) {
                new TwitterV11(TwitterDetailFragment.this.getActivity(), new TwitterDialog.OnLoginListener() {
                    public void onLogin(Twitter twitter) {
                        TwitterDetailFragment.this.twitter = twitter;
                        TwitterDetailFragment.this.doRetweet(v);
                    }

                    public void onError() {
                        TwitterDetailFragment.this.dialog.setMessage(TwitterDetailFragment.this.getString(C0846R.string.nointernetanddb));
                        TwitterDetailFragment.this.dialog.show();
                    }
                }).login(true);
            } else {
                TwitterDetailFragment.this.doRetweet(v);
            }
        }
    };
    TextView screenname;
    String screennameStr = "";
    String text;
    String time;
    Twitter twitter;

    public static TwitterDetailFragment newInstance(String id, String imgurl2, String text2, String name2, String time2) {
        TwitterDetailFragment tw = new TwitterDetailFragment();
        tw.f2088id = id;
        tw.imgurl = imgurl2;
        tw.text = text2;
        tw.nametxt = name2;
        tw.time = time2;
        return tw;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2088id);
        outState.putString("imgurl", this.imgurl);
        outState.putString("text", this.text);
        outState.putString(DBFavorites.KEY_NAME, this.nametxt);
        outState.putString(Globalization.TIME, this.time);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.twitter_detail, container, false);
        AdHelper.showAds(this, (String) null);
        if (savedInstanceState != null && this.f2088id == null) {
            this.f2088id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
            this.imgurl = savedInstanceState.getString("imgurl");
            this.text = savedInstanceState.getString("text");
            this.nametxt = savedInstanceState.getString(DBFavorites.KEY_NAME);
            this.time = savedInstanceState.getString(Globalization.TIME);
        }
        this.icon = (ImageView) v.findViewById(C0846R.C0847id.icon);
        this.media = (ImageView) v.findViewById(C0846R.C0847id.media);
        this.reply = (ImageView) v.findViewById(C0846R.C0847id.reply);
        this.retweet = (ImageView) v.findViewById(C0846R.C0847id.retweet);
        this.favorite = (ImageView) v.findViewById(C0846R.C0847id.favorite);
        this.name = (TextView) v.findViewById(C0846R.C0847id.name);
        this.screenname = (TextView) v.findViewById(C0846R.C0847id.screenname);
        this.message = (TextView) v.findViewById(C0846R.C0847id.message);
        this.date = (TextView) v.findViewById(C0846R.C0847id.date);
        this.numRetweets = (TextView) v.findViewById(C0846R.C0847id.numRetweets);
        this.reply.setOnClickListener(this.replyClick);
        this.retweet.setOnClickListener(this.retweetClick);
        this.favorite.setOnClickListener(this.favoriteClick);
        this.dialog = new AlertDialog.Builder(getActivity());
        this.dialog.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new TwitterV11(getActivity(), this.listener).login(false);
    }

    public void showStatus(final Status status) {
        FastImageLoader fil = new FastImageLoader();
        User user = status.getUser();
        fil.DisplayImage(user.getOriginalProfileImageURL(), this.icon);
        this.name.setText(user.getName());
        this.screenname.setText("@" + user.getScreenName());
        this.screennameStr = "@" + user.getScreenName();
        this.message.setText(status.getText());
        Date date2 = status.getCreatedAt();
        this.date.setText(new SimpleDateFormat("HH:mma' - 'd' 'MMM' 'yy").format(date2));
        if (status.getRetweetCount() == 0) {
            C1232UI.hide(C0846R.C0847id.numRetweets, getView());
            C1232UI.hide(C0846R.C0847id.retweets, getView());
            C1232UI.hide(C0846R.C0847id.tweetinfo, getView());
        } else {
            this.numRetweets.setText(String.valueOf(status.getRetweetCount()));
        }
        this.retweet.setSelected(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (Status rtweet : TwitterDetailFragment.this.twitter.getRetweetsOfMe()) {
                        if (rtweet.getRetweetedStatus().getId() == status.getId()) {
                            TwitterDetailFragment.this.getActivity().runOnUiThread(new Runnable() {
                                public void run() {
                                    TwitterDetailFragment.this.retweet.setSelected(true);
                                }
                            });
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        this.favorite.setSelected(status.isFavorited());
        C1232UI.hide(C0846R.C0847id.numFavorites, getView());
        C1232UI.hide(C0846R.C0847id.favorites, getView());
    }

    public void showIntent() {
        new FastImageLoader().DisplayImage(this.imgurl, this.icon);
        this.message.setText(this.text);
        this.name.setText(this.nametxt);
        this.date.setText(this.time);
        C1232UI.hide(C0846R.C0847id.tweetinfo, getView());
    }

    private class getStatusTask extends AsyncTask<Void, Void, Status> {
        private getStatusTask() {
        }

        /* synthetic */ getStatusTask(TwitterDetailFragment twitterDetailFragment, getStatusTask getstatustask) {
            this();
        }

        /* access modifiers changed from: protected */
        public Status doInBackground(Void... params) {
            try {
                return TwitterDetailFragment.this.twitter.showStatus(Long.parseLong(TwitterDetailFragment.this.f2088id));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Status result) {
            super.onPostExecute(result);
            if (result == null) {
                TwitterDetailFragment.this.showIntent();
            } else {
                TwitterDetailFragment.this.showStatus(result);
            }
        }
    }

    public void doRetweet(View v) {
        if (!v.isSelected()) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        TwitterDetailFragment.this.twitter.retweetStatus(Long.parseLong(TwitterDetailFragment.this.f2088id));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            v.setSelected(true);
        }
    }

    public void doFavorite(View v) {
        if (v.isSelected()) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        TwitterDetailFragment.this.twitter.destroyFavorite(Long.parseLong(TwitterDetailFragment.this.f2088id));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            v.setSelected(false);
            return;
        }
        new Thread(new Runnable() {
            public void run() {
                try {
                    TwitterDetailFragment.this.twitter.createFavorite(Long.parseLong(TwitterDetailFragment.this.f2088id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        v.setSelected(true);
    }
}
