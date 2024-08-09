package com.example.insta_ui

import android.os.Bundle
import android.text.Highlights
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insta_ui.ui.theme.Insta_UITheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Insta_UITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var selectedTabIndex by remember {
                        mutableStateOf(0)
                    }
                    Column(modifier = Modifier.fillMaxSize())
                    {
                        Laytopbar("tanujjoshi95", modifier = Modifier.padding(10.dp))
                        Spacer(modifier = Modifier.height(4.dp))
                        profilesec(modifier=Modifier)
                        Spacer(modifier = Modifier.height(25.dp))
                        buttonSec()
                        Spacer(modifier = Modifier.height(25.dp))
                        HighlightsSec(
                            highlights = listOf(
                                imgWithtxt(
                                    image = painterResource(id = R.drawable.me) ,
                                    text = "\uD83D\uDCABMe"
                                ),
                                imgWithtxt(
                                    image = painterResource(id = R.drawable.trip) ,
                                    text = "\uD83C\uDF0DTravel"
                                ),
                                imgWithtxt(
                                    image = painterResource(id = R.drawable.bestie) ,
                                    text = "\uD83D\uDC9CBesti"
                                ),

                                imgWithtxt(
                                    image = painterResource(id = R.drawable.friend) ,
                                    text = "\uD83D\uDC7Bfriendz"
                            ),
                                imgWithtxt(
                                    image = painterResource(id = R.drawable.click) ,
                                    text = "\uD83C\uDF05Clicks"
                                )
                            )
                            ,
                            modifier= Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        postTab(
                            imgWithtxt= listOf(
                                imgWithtxt(
                                    image = painterResource(id = R.drawable.frame_grid_icon) ,
                                    text = "grid"
                                ),
                                imgWithtxt(
                                    image = painterResource(id = R.drawable.instagram_reels_icon) ,
                                    text = "reel"
                                ),
                                imgWithtxt(
                                    image = painterResource(id = R.drawable.ic_tag_icon) ,
                                    text = "tag"
                                ),
                            )
                        )
                        {
                            selectedTabIndex=it
                        }
                        when(selectedTabIndex)
                        {
                            0->postsec(
                                post= listOf(
                                    painterResource(id =R.drawable.post1 ),
                                    painterResource(id =R.drawable.post2 ),
                                    painterResource(id =R.drawable.post3 )
                                )
                            )
                        }

                    }
                }
            }
        }
    }


}

@Composable
fun Laytopbar(name: String, modifier: Modifier = Modifier) {
    
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription =null,
            tint = Color.Black,
            modifier = modifier.size(24.dp))
        Text(text = name,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            fontSize = 20.sp
            )
        Icon(painter = painterResource(id = R.drawable.ic_bell_regular), contentDescription =null,
            tint = Color.Black,
            modifier = modifier.size(24.dp))
        Icon(painter = painterResource(id = R.drawable.ellipsis_vertical_solid),
            contentDescription =null,
            modifier = modifier.size(24.dp)
        )


    }


}
@Composable
fun profilesec(modifier: Modifier=Modifier) {
    Column ( modifier.fillMaxWidth())
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
           modifier= Modifier
               .fillMaxWidth()
               .padding(horizontal = 20.dp)

        ) {
            roundimage(image = painterResource(id = R.drawable.profilepic),
                        modifier = Modifier
                            .size(100.dp)
                            .weight(3f)
                  )
            Spacer(modifier = modifier.width(16.dp))
            pstats(modifier=Modifier.weight(7f))
//            Spacer(modifier = Modifier.height())
        }
        despo(
            profaname="Tanuj Joshi",
            descrp="♎ libra\n" +
                    "\uD83D\uDE07simplicity\n" +
                    "\uD83D\uDCABLiving life ☘on my own terms.",
            othercount=10
        )

    }



}

@Composable
fun roundimage(image:Painter ,modifier:Modifier=Modifier)
{
    Image(painter = image,
        contentDescription =null,
        modifier
            .aspectRatio(1f, true)
            .border(
                width = 1.dp, color = Color.LightGray, shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
            )
}

@Composable
fun pstats(

    modifier: Modifier=Modifier)
{
    Row (
        verticalAlignment =Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ){
        stats(number = "3", text ="post" )
        stats(number = "140", text ="followers" )
        stats(number = "116", text ="following" )
    }

}

@Composable
fun stats(
    number:String,
    text:String,
    modifier: Modifier=Modifier
)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier=modifier
    ) {
        Text(text = number,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
            )
        Spacer(modifier = modifier.height(4.dp))
        Text(text = text)
    }

}

@Composable
fun despo(profaname:String,descrp:String,othercount:Int)
{
    val letterspacing=0.5.sp
    val lineheight=20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(text = profaname,
            letterSpacing = letterspacing,
            lineHeight = lineheight,
            fontWeight = FontWeight.Bold
            )
        Text(text = descrp,
            letterSpacing = letterspacing,
            lineHeight = lineheight,
            fontWeight = FontWeight.Medium
            )
        Row(


        ) {
            Text(text ="Followed by ",
                letterSpacing = letterspacing,
                lineHeight = lineheight,
                fontWeight = FontWeight.Medium)
            Text(text = "Elon Musk,Bill Gates ",
                fontWeight = FontWeight.Bold,
                letterSpacing = letterspacing,
                lineHeight = lineheight
            )
            Text(text = "and $othercount others",
                letterSpacing = letterspacing,
                lineHeight = lineheight ,
                fontWeight = FontWeight.Medium)

        }
    }
}
@Composable
fun buttonSec(
    modifier: Modifier=Modifier
)
{
    val widh=95.dp
    val height=30.dp
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier=modifier.fillMaxWidth()
    ){
        actionButton(
            text="Following",
            icon=Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = widh)
                .height(height)

        )
        actionButton(text="Message",
            modifier = Modifier
                .defaultMinSize(minWidth = widh)
                .height(height)
            )
        actionButton(text="Email",
            modifier = Modifier
                .defaultMinSize(minWidth = widh)
                .height(height)
            )
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(5.dp)
                )
                .size(height)
                .padding(6.dp)
        ){
            Image(painter = painterResource(id = R.drawable.invite), contentDescription =null )
            }

        }

    }
@Composable
fun actionButton(
    text: String? = null,
    icon: ImageVector? = null,
    modifier: Modifier=Modifier
)
{
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ){
        if(text!=null)
        {
            Text(text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if(icon!=null)
        {
            Icon(imageVector = icon,
                contentDescription =null ,
                tint = Color.Black
                )
        }

    }


}

@Composable
fun HighlightsSec(
    highlights:List<imgWithtxt>,
    modifier: Modifier=Modifier
)
{
    LazyRow(modifier = modifier){
        items(highlights.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                    roundimage(image = highlights[it].image,
                        modifier = Modifier.size(70.dp))
                    Text(text = highlights[it].text,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center)
            }
        }

    }
}

@Composable
fun postTab(
    modifier: Modifier=Modifier,
    imgWithtxt:List<imgWithtxt>,
    ontabselected:(selectIndex:Int)-> Unit

){
    var selectTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(selectedTabIndex = selectTabIndex,
        Modifier.background(Color.Transparent),
        contentColor = Color.Black
        )
    {
        imgWithtxt.forEachIndexed { index, item ->
            Tab(selected = selectTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectTabIndex=index
                    ontabselected(index)
                }) {
                Icon(painter = item.image, contentDescription =item.text ,
                    tint = if (selectTabIndex==index) Color.Black else inactiveColor,
                    modifier= Modifier
                        .padding(10.dp)
                        .size(20.dp))
            }
        }

    }

}

@Composable
fun postsec(
    post:List<Painter>,
    modifier: Modifier=Modifier
)
{
    LazyVerticalGrid(columns = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f) )
    {
        items(post.size){
            Image(painter = post[it],
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.
            aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    ))
        }
    }


}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Insta_UITheme {
//        Laytopbar("tanujjoshi95")
//    }
//}