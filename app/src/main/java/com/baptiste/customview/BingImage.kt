package com.baptiste.customview

data class BingImage(
    var _type: String? = null,
    var instrumentation: Instrumentation? = null,
    var readLink: String? = null,
    var webSearchUrl: String? = null,
    var queryContext: QueryContext? = null,
    var totalEstimatedMatches: String? = null,
    var nextOffset: String? = null,
    var currentOffset: String? = null,
    var value: List<Value>? = null
) {}

data class Instrumentation(
    var _type: String? = null
) {}

data class QueryContext(
    var originalQuery: String? = null,
    var alterationDisplayQuery: String? = null,
    var alterationOverrideQuery: String? = null,
    var alterationMethod: String? = null,
    var alterationType: String? = null
) {}

data class Value(
    var webSearchUrl: String? = null,
    var name: String? = null,
    var thumbnailUrl: String? = null,
    var datePublished: String? = null,
    var isFamilyFriendly: String? = null,
    var contentUrl: String? = null,
    var hostPageUrl: String? = null,
    var contentSize: String? = null,
    var encodingFormat: String? = null,
    var hostPageDisplayUrl: String? = null,
    var thumbnail: Thumbnail? = null,
    var imageInsightsToken: String? = null,
    var insightsMetadata: InsightsMetadata? = null,
    var imageId: String? = null,
    var accentColor: String? = null
) {}

data class Thumbnail(
    var width: String? = null,
    var height: String? = null
) {}

data class InsightsMetadata(
    var pagesIncludingCount: String? = null,
    var availableSizesCount: String? = null
) {}