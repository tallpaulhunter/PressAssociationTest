Feature: Test Something

  Scenario Outline: Retrieve details of all songs
    When I request a list of songs
    Then response code is <response code>
    And list of all songs is returned
    And song id is <id>
    And song Artist is <artist>
    And song Title <title>
    And song V value is <v>
    And song publish date is <publish date>
    And song date created is <date created>

    Examples:
      |response code|id                      |artist    |title      |v|publish date            |date created            |
      |200          |596cac389f0525001db52244|Ed Sheeran|Galway Girl|0|2013-02-01T00:00:00.000Z|2017-07-17T12:23:20.639Z|
      |200          |596cbda86ed7c10011a68b24|Lady Gaga |Poker face |0|2017-09-01T00:00:00.000Z|2017-07-17T13:37:44.559Z|
      |200          |596cc3b16ed7c10011a68b26|Ed Sheeran|Galway Girl|0|2013-02-01T00:00:00.000Z|2017-07-17T14:03:29.649Z|

  Scenario Outline: Retrieve details on a single song
    When I request details for a song with <id>
    Then response code is <response code>
    And only details of one song are returned
    And song id is <id>
    And song Artist is <artist>
    And song Title <title>
    And song V value is <v>
    And song publish date is <publish date>
    And song date created is <date created>

    Examples:
      |response code|id                      |artist    |title      |v|publish date            |date created            |
      |200          |596cbda86ed7c10011a68b24|Lady Gaga |Poker face |0|2017-09-01T00:00:00.000Z|2017-07-17T13:37:44.559Z|
      |200          |596cc3b16ed7c10011a68b26|Ed Sheeran|Galway Girl|0|2013-02-01T00:00:00.000Z|2017-07-17T14:03:29.649Z|

  Scenario Outline: Post a new song
    #Given new song Artist is <artist>
    #And new song Title <title>
    #And new song publish date is <publish date>
    When I post a new song
    Then response code is <response code>
    And only details of one song are returned
    And song V value is <v>
    And song Title <title>
    And song Artist is <artist>
    And song publish date is <publish date>
    And song id is <id>
    And song date created is <date created>

    Examples:
      |response code|id                      |artist    |title      |v|publish date            |date created            |
      |201          |596cabbe9f0525001db52242|Lady Gaga |Poker face |0|2017-09-01T00:00:00.000Z|2017-07-17T12:21:18.580Z|

  Scenario Outline: Update a video
    When I post an update to an existing song
    Then response code is <response code>
    And Response body will be Not implemented
    Examples:
      | response code  |
      | 501            |

  Scenario: Delete a video
