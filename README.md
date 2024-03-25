# User Engagement Microservice 
This is the repository for user engagement microservice.
This microservice handles apis related to the user engagement:
* Incrementing the likes, clicks for the post
* Decrementing likes for the post
* Retrieving the most popular blogs based on number of likes
* Retrieving the user engagement for the given blog post
	
This module stores the likes and clicks per post. It also contains the columns for dislikes but that functoinality has not yet been implemented.

User engagement has been implemented as a different service for the following reasons:

1. This provides a way to perform and enhance various analytical operations on user engagement data indenpendent of the blog posts e.g. calculating the combined scores.
2. Since the frequency of users liking/ disliking and clicking the blog posts is way higher than the actual creation/ updation of the blog posts, it may require sclaing to a different extent.
3. Also, when the home page also presents the most populat blogs and this can also be catered to with a different microservice handling it. 

Limitations:

1. As this service simply provides ways to increment and decrement like counts, a user can like and dislike a post several times. It does not store the likes and dislikes per user. This is for later versions.
2. Currently, the like increments, decrements and click increments are done directly in the database. This model, however, is not well suited to scaling when the traffic increases. 
   *Solution*: For such purposes, it would be ideal to use a distributed cache like Redis which can periodically write to the database. 
   This was not possible to implement due to limitations in home development environment and should be for later versions.
3. Currently user engagement is basically number of likes for a blog post. This can be easily changed to make use of a combined score.


 