package com.example.orderapp

data class Game(
    var achievements_count: Int,
    var added: Int,
    var added_by_status: AddedByStatus,
    var additions_count: Int,
    var alternative_names: List<String>,
    var background_image: String,
    var background_image_additional: String,
    var creators_count: Int,
    var description: String,
    var esrb_rating: EsrbRating,
    var game_series_count: Int,
    var id: Int,
    var metacritic: Int,
    var metacritic_platforms: List<MetacriticPlatform>,
    var metacritic_url: String,
    var movies_count: Int,
    var name: String,
    var name_original: String,
    var parent_achievements_count: String,
    var parents_count: Int,
    var platforms: List<Platform>,
    var playtime: Int,
    var rating: Float,
    var rating_top: Int,
    var ratings_count: Int,
    var reddit_count: Int,
    var reddit_description: String,
    var reddit_logo: String,
    var reddit_name: String,
    var reddit_url: String,
    var released: String,
    var reviews_text_count: String,
    var screenshots_count: Int,
    var slug: String,
    var suggestions_count: Int,
    var tba: Boolean,
    var twitch_count: String,
    var updated: String,
    var website: String,
    var youtube_count: String
)