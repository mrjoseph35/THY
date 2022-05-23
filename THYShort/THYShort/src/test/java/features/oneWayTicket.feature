Feature: Taking Ticket from THY

  Scenario: Taking a oneway Ticket from THY
    Given user on THY homepage
    When  user select oneway
    And   user select a ticket as follows
      | fromCity    | Istanbul  |
      | fromAirport | SAW       |
      | toCity      | Frankfurt |
      | toAirport   | FRA       |
      | month       | Juni      |
      | day         | 22        |

