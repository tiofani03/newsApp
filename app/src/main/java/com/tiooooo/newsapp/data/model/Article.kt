package com.tiooooo.newsapp.data.model

import kotlinx.serialization.Serializable
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Serializable
data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String,
)

@Serializable
data class Source(
    val id: String?,
    val name: String,
)

val article1 = Article(
    source = Source("engadget", "Engadget"),
    author = "Lawrence Bonk",
    title = "Save over $100 on the 10th-gen iPad with two years of AppleCare+",
    description = "Apple’s 10th-gen iPad is on sale via Amazon as part of a bundle that includes two years of AppleCare+ warranty coverage...",
    url = "https://www.engadget.com/save-over-100-on-the-10th-gen-ipad-with-two-years-of-applecare-162654321.html",
    urlToImage = "https://s.yimg.com/ny/api/res/1.2/Vk8oeiKJZbWYpP6bC5796w--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDI-/https://s.yimg.com/os/creatr-uploaded-images/2024-02/579e0770-c1e5-11ee-ac7f-d084f0753467",
    publishedAt = "2024-02-02T16:26:54Z",
    content = "Apples 10th-gen iPad is on sale via Amazon as part of a bundle that includes two years of AppleCare+ warranty coverage. The discount brings the price of the 64GB model down to $409 from $518, which i… [+1772 chars]"
)

val dummyListArticle: List<Article> = listOf(
    Article(
        Source("the-verge", "The Verge"),
        "Emilia David",
        "Shopify’s ‘Magic’ AI image editor can make any product pics look professional",
        "Shopify adds more AI features to the platform. It now offers AI image editing for sellers to change backgrounds on product photos and more intuitive searches.",
        "https://www.theverge.com/24056980/shopify-generative-ai-image-editing-search",
        "https://cdn.vox-cdn.com/thumbor/iE3UqZHrFdk0Fr3cyMCRFurz7hc=/0x0:3840x2160/1200x628/filters:focal(1920x1080:1921x1081)/cdn.vox-cdn.com/uploads/chorus_asset/file/25259010/videoframe_1049267.png",
        "2024-01-31T18:22:29Z",
        "Shopify’s Magic AI image editor can make any product pics look professional\r\nShopify’s Magic AI image editor can make any product pics look professional\r\n / Shopifys e-commerce platform is adding more … [+2698 chars]"
    ),
    Article(
        Source(null, "Search Engine Journal"),
        "Daniel Smullen",
        "How To Use ChatGPT For Keyword Research (Festive Flashback) via @sejournal, @dansmull",
        "Unleash the power of ChatGPT in keyword research and make it an invaluable addition to your SEO toolbox using this guide.",
        "https://www.searchenginejournal.com/how-to-use-chatgpt-for-keyword-research-festive-flashback/502156/",
        "https://www.searchenginejournal.com/wp-content/uploads/2023/12/2-ff-chatgpt-for-keyword-research-657a84d71aa7d-sej.jpg",
        "2024-01-05T09:15:30Z",
        "Celebrate the Holidays with some of SEJ’s best articles of 2023.\r\nOur Festive Flashback series runs from December 21 – January 5, featuring daily reads on significant events, fundamentals, actionable… [+14691 chars]"
    ),
    Article(
        Source(null, "Search Engine Journal"),
        "Andy Chadwick",
        "How To Do Keyword Research For Very Specific, B2B Audiences (A Case Study) via @sejournal, @digitalquokka",
        "Discover how to navigate a particularly tough keyword research brief and apply this critical thinking-based approach to any B2B niche.",
        "https://www.searchenginejournal.com/how-to-keyword-research-specific-b2b-audiences-case-study/500398/",
        "https://www.searchenginejournal.com/wp-content/uploads/2023/11/untitled-design-53-654b6247e106b-sej.png",
        "2024-01-10T10:00:23Z",
        "I’m taking you behind the scenes of a particularly tough keyword research brief we tackled. I’ll break down our approach, share our strategies, and reveal how we executed the research with a dash of … [+9600 chars]"
    ),
    Article(
        Source(null, "9to5Mac"),
        "Filipe Espósito",
        "Threads just got another update with option to show the latest search results",
        "It’s been a while since Meta’s microblogging platform, Threads, released its keyword search feature to users around the world. However, one huge downside is that Threads search doesn’t let users see search results in reverse chronological order. But that’s ch…",
        "https://9to5mac.com/2024/01/08/threads-search-latest-results/",
        "https://i0.wp.com/9to5mac.com/wp-content/uploads/sites/6/2023/07/instagram-threads-icon.webp?resize=1200%2C628&quality=82&strip=all&ssl=1",
        "2024-01-09T02:35:49Z",
        "It’s been a while since Meta’s microblogging platform, Threads, released its keyword search feature to users around the world. However, one huge downside is that Threads search doesn’t let users see … [+1769 chars]"
    ),
    Article(
        Source(null, "Small Business Trends"),
        "Shubhomita Bose",
        "Use “Gift” as Keyword For Valentine’s Day Online Marketing",
        "Planning on a special marketing effort for Valentine's Day this year? New data suggests that using the word \"gift\" is a must in a promo and don't forget about singles, who also tend to spend more on a day that targets couples.",
        "https://smallbiztrends.com/2023/08/gift-valentines-day-keyword-online-marketing.html",
        "https://media.smallbiztrends.com/2016/01/valentines-gift-BING-1-660x370.png",
        "2024-01-02T08:42:47Z",
        "Valentines Day isnt just a symbol of love; its a major commercial event and a key opportunity for businesses, especially those offering classic gifts like chocolates, cards, and bouquets. With the da… [+10020 chars]"
    ),
    Article(
        Source(null, "Toprankblog.com"),
        "Harry Mackin",
        "What to Look For in an SEO Analysis of a Website",
        "Conducting a thorough SEO analysis of a website provides much more than a list of keywords. An in-depth examination of...\nThe post What to Look For in an SEO Analysis of a Website appeared first on B2B Marketing Blog - TopRank®.",
        "https://www.toprankblog.com/2024/01/seo-analysis-of-a-website/",
        "https://www.toprankblog.com/wp-content/uploads/shutterstock_1626375367-scaled.jpg",
        "2024-01-17T11:30:38Z",
        "Conducting a thorough SEO analysis of a website provides much more than a list of keywords. An in-depth examination of your SEO strategy helps enhance every aspect of your brands marketing. It provid… [+6009 chars]"
    ),
    Article(
        Source(null, "Boing Boing"),
        "Natalie Dressed",
        "Forme LA Sheriff Villaneuva says sheriff gangs are simply subgroups",
        "\"They exist everywhere, and they will always exist.\" — the sheriff gangs of Los Angeles are hardly any secret at all anymore. What with numerous exposes, very public trials, and an entire Wikipedia page listing the known ones, I'd venture so far as to say tha…",
        "https://boingboing.net/2024/01/16/forme-la-sheriff-villaneuva-says-sheriff-gangs-are-simply-subgroups.html",
        "https://boingboing.net/wp-content/uploads/2020/08/Depositphotos_350114310_s-2019.jpg",
        "2024-01-16T16:27:00Z",
        "\"They exist everywhere, and they will always exist.\" the sheriff gangs of Los Angeles are hardly any secret at all anymore. What with numerous exposes, very public trials, and an entire Wikipedia pag… [+1339 chars]"
    ),
    Article(
        Source(null, "ReadWrite"),
        "Ali Rees",
        "Researchers create AI that can ‘jailbreak’ other chatbots",
        "Researchers at the Nanyang Technology University (NTU) in Singapore have created an artificial intelligence (AI) chatbot that can circumvent protections…\nThe post Researchers create AI that can ‘jailbreak’ other chatbots appeared first on ReadWrite.",
        "https://readwrite.com/researches-create-ai-that-can-jailbreak-other-ai/",
        "https://readwrite.com/wp-content/uploads/2024/01/DALL·E-2024-01-02-12.05.06-A-conceptual-abstract-representation-of-jailbreaking-AI-chatbots-avoiding-any-depiction-of-robots-or-humans.-The-image-focuses-on-symbolic-element.png",
        "2024-01-02T12:06:10Z",
        "Researchers at the Nanyang Technology University (NTU) in Singapore have created an artificial intelligence (AI) chatbot that can circumvent protections on chatbots such as ChatGPT and Google Bard, c… [+2153 chars]"
    ),
    Article(
        Source(null, "9to5Mac"),
        "Filipe Espósito",
        "Threads just got another update with option to show the latest search results [U: Pulled]",
        "It’s been a while since Meta’s microblogging platform, Threads, released its keyword search feature to users around the world. However, one huge downside is that Threads search doesn’t let users see search results in reverse chronological order. But that’s ch…",
        "https://9to5mac.com/2024/01/09/threads-search-latest-results/",
        "https://i0.wp.com/9to5mac.com/wp-content/uploads/sites/6/2023/07/instagram-threads-icon.webp?resize=1200%2C628&quality=82&strip=all&ssl=1",
        "2024-01-09T20:20:00Z",
        "It’s been a while since Meta’s microblogging platform, Threads, released its keyword search feature to users around the world. However, one huge downside is that Threads search doesn’t let users see … [+2107 chars]"
    ),
    Article(
        Source(null, "Android Central"),
        "tips@androidcentral.com (Nickolas Diaz)",
        "Google's new Gen AI in Maps can help you find places to go and things to do",
        "Google detailed a few new generative AI-backed features that will soon arrive for a select few users in the U.S.",
        "https://www.androidcentral.com/apps-software/google-details-gen-ai-search-maps",
        "https://cdn.mos.cms.futurecdn.net/hFR48buiix3bdGhANJNSJ6-1200-80.jpg",
        "2024-02-01T21:21:01Z",
        "<ul><li>Google states new generative AI-backed search capabilities will soon arrive for \"select\" Local Guides in the U.S.</li><li>The AI can help users find locations based on their queries or pre-ma… [+2566 chars]"
    )
)

fun convertDateFormat(inputDate: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("d MMM yyyy", Locale.getDefault())

    return try {
        val date: Date =
            inputFormat.parse(inputDate) ?: throw ParseException("Invalid date format", 0)
        outputFormat.format(date)
    } catch (e: ParseException) {
        val todayDate = Calendar.getInstance().time
        outputFormat.format(todayDate)
    }
}

fun calculateMinutesBasedOnCharCount(inputString: String): Int {
    try {
        val charCountPattern = "\\[\\+(\\d+) chars]".toRegex()
        val matchResult = charCountPattern.find(inputString)

        val charCount = matchResult?.groupValues?.get(1)?.toIntOrNull() ?: 0

        return when {
            charCount < 1000 -> 5
            charCount in 1000..1999 -> 7
            charCount in 2000..2999 -> 10
            charCount in 3000..3999 -> 15
            else -> 20
        }
    } catch (e: Exception) {
        return 5
    }
}

