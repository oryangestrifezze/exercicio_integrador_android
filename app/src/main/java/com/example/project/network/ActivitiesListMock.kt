package Network
import com.example.project.model.ActivityModel
import com.example.project.R


object ActivityList {
    fun getActivityList(): List<ActivityModel> {
        return listOf(
            ActivityModel(
                id = 1,
                image= R.drawable.education_icon,
                activity = "education",
                title = "Lorem ipsum dolor sit amet.",
                price = "Free"

            ),

            ActivityModel(
                id = 2,
                image= R.drawable.recreational_icon,
                activity = "recreational",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 3,
                image= R.drawable.social_icon,
                activity = "social",
                title = "Lorem ipsum dolor sit amet.",
                price = "Higth"
            ),
            ActivityModel(
                id = 4,
                image= R.drawable.diy_icon,
                activity = "diy",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 5,
                image= R.drawable.charity_icon,
                activity = "charity",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 6,
                image= R.drawable.cooking_icon,
                activity = "cooking",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 7,
                image= R.drawable.relaxation_icon,
                activity = "relaxation",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 8,
                image= R.drawable.music_icon,
                activity = "music",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 9,
                image= R.drawable.work_icon,
                activity = "busywork",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
        )
    }
}