# Introduction

A search engine is a well-managed and sophisticated set of entangled programs that identifies and searches for preexisting information in a datastore and presents it to the user based on a matching criteria. Search engines provide easy access to the available information and are the most common mechanism used on the internet. 

Google and Bing are the most commonly used search engines for exploring the World Wide Web. Modern-day search engines perform the following operations:

- Crawling: Crawlers discover existing websites. A search engine maintains a list of available pages and constantly crawls the web for updated pages. This process is called URL discovery. Upon the discovery of a web page, the crawler determines its content. The search engine uses an algorithm to determine the frequency and list of pages to crawl.
- Deduplication: The search engines process the textual content crawled from a web page. The content is tagged with details and attributes called metadata that help the search engine understand the nature of the content. This also enables the search engine to separate duplicate pages and allows it to accumulate more data about the content, such as the page's demographics (country or region), target audience, and much more.
- Ranking: Whenever a user submits a query, the engine queries the index for the matching pages and returns the most relevant result to the user. Utilizing multiple factors like the keywords on a page, page size, previous visits to the page, and specialized ranking, it serves the selected content to the user. Examples of specialized ranking include presenting websites containing content in the native language of the country. In addition, corporate company sites might use an index to retrieve only the content from that company's internal domain. 

## What are the standard features of a search engine?

### Search results ranking

Search engines sort content by using ranking algorithms. Modern-day search engines rank results based on the following criteria:

- Query meaning: The search engine identifies the search intent based on the type of content the user is searching for. Language model algorithms read user input, understand its meaning, identify the type of information a user is searching for, and display the result.
- Relevance: Relevance of the content is calculated by checking how many times the keywords appear in the text.
- User data: Search engines recommend content based on the previous search history, a user's search settings, and their current location.

### Search query autocomplete

A widespread application of the trie is auto-complete or type-ahead suggestions. For example, once a user types a letter, the list of potential word queries is significantly reduced, allowing the program to evaluate possible query strings quickly. In a real-life search engine, along with words, much other information is maintained for query strings. Only words can be stored in a dictionary or a state machine, but a trie can store extra information about query words. For example, a trie can store details about the word's popularity, search count, and more. That's why when a user types "his," "history" is suggested before "Hispanic".

### Search query spelling correction

Real-life search engines have the built-in capability to correct spelling, known as spell-checking or autocorrect. It checks for the word in the data dictionary, generates potential suggestions, and presents solutions based on priority order. A viable data structure like a trie is used to store the data dictionary. Finally, different trie traversal and searching algorithms are used to generate the suggestions.

## Search engine using tries

Tries are efficient data structures for string search-related operations. Let's try to solve the most basic search engine problem. You're given a list of words present in the datastore and a list of query words. Design a search engine that identifies and returns if the word is present in the datastore partially (as a prefix) or completely. 

```
Input
datastore: ["app", "apple", "apply", "ape", "apex", "ate"]
query words: "app"

Output: ["app", "apple", "apply"]
```

It's apparent that the problem is related to strings and prefix search. We insert all the datastore words into a trie. Next, we search the query word in the trie. While searching for a word in the trie, we can encounter the following three conditions:

- Condition 1: Found as a complete word

If we reach the last character of the word and isEndOfWord is set as true for the trie node, it means we've found a complete word.

- Condition 2: Found as a prefix

If we reach the last character of the word and isEndOfWord is false for the trie node, it implies the current word is a prefix for some word of the datastore.

- Condition 3: Not found

If a letter of the provided word is not found in the trie before the entire length of the provided word is iterated, it implies that the current word is not present in the trie and therefore doesn't exist in the datastore, either as a complete word or a prefix.
