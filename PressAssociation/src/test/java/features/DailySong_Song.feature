Feature: Test Something

  Scenario: Retrieve details of all songs
    When I request a list of songs
    Then response code is 200
    And list of all songs is returned
    | id                       | artist     | song        | publish date             | v | date created             |
    | 598b088d59bb170011e83424 | Lady Gaga  | Poker face  | 2017-09-01T00:00:00.000Z | 0 | 2017-08-09T13:05:17.120Z |
    | 598b0db359bb170011e83425 | Lady Gaga  | Poker face  | 2017-09-01T00:00:00.000Z | 0 | 2017-08-09T13:27:15.332Z |
    | 598b12bd59bb170011e83426 | Lady Gaga  | Poker face  | 2017-09-01T00:00:00.000Z | 0 | 2017-08-09T13:48:45.541Z |
    | 598b133d59bb170011e83427 | Lady Gaga  | Poker face  | 2017-09-01T00:00:00.000Z | 0 | 2017-08-09T13:50:53.466Z |


  Scenario Outline: Retrieve details of a single song
    When I request details for a song with <id>
    Then response code is 200
    And details of 1 song are returned
    And list of all songs is returned
    | id                       | artist     | song        | publish date             | v | date created             |
    | 598b088d59bb170011e83424 | Lady Gaga  | Poker face  | 2017-09-01T00:00:00.000Z | 0 | 2017-08-09T13:05:17.120Z |

    Examples:
      | id                       |
      | 598b088d59bb170011e83424 |

  Scenario Outline: Post a new song
    When i post a new song with artist <artist>, song <song>, and publish date <publish date>
    Then response code is 201
    And details of 1 song are returned
    And v value is 0
    And song value is <song>
    And artist value is <artist>
    And publishDate value is <publish date>
    And _id value is not blank
    And date_created value is today

    Examples:
      | artist     | song        | publish date |
      | Ed Sheeran | Galway Girl | 2017-09-01   |

  Scenario Outline: Update a video
    When I post an update to an existing song with Id <id>
    Then response code is <response code>
    And response body will be Not implemented
    Examples:
      | id                       | response code  |
      | 598b088d59bb170011e83427 | 501            |

  #always run after "Post a new song" and delete the created song (highest Id)
  Scenario: Delete a video
    When I delete a video
    Then response code is 204
    And response body will be N/A

