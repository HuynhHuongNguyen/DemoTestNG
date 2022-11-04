Feature: Booking

  Scenario Outline: Booking a Walk-in
    Given I log in as "<username>" and "<password>"
    When  I select to open "<option>"

  Examples:
  | username | password | option | venue_name | table | customer_name | booking_note |
  | z.d.r.a.v.k.o.stojkoski@gmail.com | ThePassword01##!! | Admin Portal | My Pizza Shop | T1 * C21 outside | Joes | testing |
