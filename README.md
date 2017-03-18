# Cinema (LetsMath Assignment)<img src="app/src/main/res/mipmap-hdpi/ic_launcher.png" />

- apk(debug-unsigned): https://drive.google.com/open?id=0B2nGf8LzrZuJZ1pRMWtqQUN2eU0

# ScreenShots
- Portrait Mode </br></br>
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/lm0.jpg?alt=media&token=e85d0730-51ac-4259-8514-6a1d9d94394f"  
width = 250>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/lm1.jpg?alt=media&token=795892b7-77ee-4d46-b03a-cec33ce2719a"  
width = 250>&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/lm2.jpg?alt=media&token=c43da333-316b-47b8-87f3-93a8ca6e4609"  
width = 250>&nbsp;&nbsp; </br></br>

- LandScape Mode </br></br>
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/lm3.jpg?alt=media&token=aeccd0d3-fae3-4411-a0bb-489fa4c7ddf5"  
width = 420>&nbsp;&nbsp;
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/lm4.jpg?alt=media&token=9371dfa5-3b56-4127-8609-756537d3aaf2"  
width = 420></br></br></br>
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/lm5.jpg?alt=media&token=e7807166-1a43-45f6-85c8-66a40d8c9e4f"  
width = 420>&nbsp;&nbsp;
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/lm6.jpg?alt=media&token=352c7f0b-68bb-46ff-87d7-36d5b24c53ec"  
width = 420>&nbsp;&nbsp; </br></br>

# NOTE
- App works in both portrait and landscape mode
- I have added comments wherever I find it necessary
- I have added some dummy data in ArrayList to populate the RecyclerView(see addSampleContent() in MainActivity)
- 8 movies each under In theaters & Upcoming Movies section
- Click on a Card to open new activity which shows detail information about that particular movie. The top section consists of a 
RecyclerView which shows all the movie trailers associated with that movie(Number of trailers are different for each movie) 
- Do horizontal swipe to go through each movie trailer and click on it to play the trailer
- I was going through some videos on ExoPlayer library & I came to know that YouTube API also uses it internally. So I have used YouTube API
for video handling

<b>Ps</b>: If you want me to implement own mediaplayer using ExoPlayer, it will take more time as it requires too many callbacks to be implemented
and a lot of things need to be care of especially creating .m3u8 playlist and corresopondig .ts files and hosting them on a web server
(if using HLS format). Plus adding all the buttons to play,pause,menu for video quality,and implementing their functionality, handling 
configuration changes and network disconnection-reconnection events also. Most of these things are included in YouTube API. 

I should have moved all the hardcoding to respective resource files but I didn't get enough time to do so. Sorry for that.

# Components Used
- Gradient Background
- RecyclerView
- GridLayout
- CardView
- POJO Model class for storing Movie details(name,summary, rating etc.)
- RecyclerView.Adapter and ViewHolder
- YouTube API

<b> Hope You'll like it :-)
