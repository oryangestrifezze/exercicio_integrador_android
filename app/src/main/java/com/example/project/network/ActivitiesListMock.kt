package Network
import com.example.project.model.ActivityModel

object ActivityList {
    fun getActivityList(): List<ActivityModel> {
        return listOf(
            ActivityModel(
                id = 1,
                activity = "education",
                title = "Lorem ipsum dolor sit amet.",
                price = "Free"
            ),

            ActivityModel(
                id = 2,
                activity = "recreational",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 3,
                activity = "social",
                title = "Lorem ipsum dolor sit amet.",
                price = "Higth"
            ),
            ActivityModel(
                id = 4,
                activity = "diy",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 5,
                activity = "charity",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 6,
                activity = "cooking",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 7,
                activity = "relaxation",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 8,
                activity = "music",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
            ActivityModel(
                id = 9,
                activity = "busywork",
                title = "Lorem ipsum dolor sit amet.",
                price = "Medium"
            ),
        )
    }
}