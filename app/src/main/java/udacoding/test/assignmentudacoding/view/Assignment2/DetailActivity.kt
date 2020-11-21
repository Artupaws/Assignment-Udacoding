package udacoding.test.assignmentudacoding.view.Assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import udacoding.test.assignmentudacoding.R

class DetailActivity : AppCompatActivity() {

    var name: String = ""
    lateinit var tv_name: TextView
    lateinit var iv:ImageView
    lateinit var tv_description:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tv_name = findViewById(R.id.tv_name)
        tv_description = findViewById(R.id.tv_description)
        iv = findViewById(R.id.iv)

        name = intent.extras?.get("name").toString()
        tv_name.text = name
        setDescription()
        setImage()

    }

    private fun setDescription(){
        if (name == "Iron Man"){
            tv_description.setText(R.string.desc_ironman)
        } else if (name == "Spider Man"){
            tv_description.setText(R.string.desc_spiderman)
        } else if (name == "Hawk Eye") {
            tv_description.setText(R.string.desc_hawkeye)
        } else if (name == "Hulk") {
            tv_description.setText(R.string.desc_hulk)
        } else if (name == "Dr Strange") {
            tv_description.setText(R.string.desc_strange)
        } else if (name == "Wanda") {
            tv_description.setText(R.string.desc_wanda)
        } else if (name == "Vision") {
            tv_description.setText(R.string.desc_vision)
        } else if (name == "Black Panther") {
            tv_description.setText(R.string.desc_black_panther)
        } else if (name == "Black Widow") {
            tv_description.setText(R.string.desc_black_widow)
        } else if (name == "Ant Man") {
            tv_description.setText(R.string.desc_antman)
        } else if (name == "Rocket Raccoon") {
            tv_description.setText(R.string.desc_rocket_raccoon)
        } else if (name == "Groot") {
            tv_description.setText(R.string.desc_groot)
        } else if (name == "Tesla Model X"){
            tv_description.setText(R.string.desc_tesla_x)
        } else if (name == "Tesla Model S"){
            tv_description.setText(R.string.desc_tesla_s)
        } else if (name == "Tesla Model 3"){
            tv_description.setText(R.string.desc_tesla_3)
        } else if (name == "Tesla Cybertruck"){
            tv_description.setText(R.string.desc_tesla_cybertruck)
        } else if (name == "Tesla Roadster"){
            tv_description.setText(R.string.desc_tesla_roadster)
        }
    }

    private fun setImage(){
        if (name == "Iron Man"){
            iv.setImageResource(R.drawable.ironman)
        } else if (name == "Spider Man"){
            iv.setImageResource(R.drawable.spiderman)
        } else if (name == "Hawk Eye") {
            iv.setImageResource(R.drawable.hawkeye)
        } else if (name == "Hulk") {
            iv.setImageResource(R.drawable.hulk)
        } else if (name == "Dr Strange") {
            iv.setImageResource(R.drawable.strange)
        } else if (name == "Wanda") {
            iv.setImageResource(R.drawable.wanda)
        } else if (name == "Vision") {
            iv.setImageResource(R.drawable.vision)
        } else if (name == "Black Panther") {
            iv.setImageResource(R.drawable.blackpanther)
        } else if (name == "Black Widow") {
            iv.setImageResource(R.drawable.blackwidow)
        } else if (name == "Ant Man") {
            iv.setImageResource(R.drawable.antman)
        } else if (name == "Rocket Raccoon") {
            iv.setImageResource(R.drawable.rocket)
        } else if (name == "Groot") {
            iv.setImageResource(R.drawable.groot)
        } else if (name == "Tesla Model X"){
            iv.setImageResource(R.drawable.teslamodelx)
        } else if (name == "Tesla Model S"){
            iv.setImageResource(R.drawable.teslamodels)
        } else if (name == "Tesla Model 3"){
            iv.setImageResource(R.drawable.teslamodel3)
        } else if (name == "Tesla Cybertruck"){
            iv.setImageResource(R.drawable.teslacybertruck)
        } else if (name == "Tesla Roadster"){
            iv.setImageResource(R.drawable.teslaroadster)
        }
    }

}