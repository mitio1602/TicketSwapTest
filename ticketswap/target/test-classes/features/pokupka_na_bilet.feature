Feature: Покупка на билет

Scenario: Успешна покупка на билет
Given че съществува билет с наличност
And че потребителят е влязъл в системата
When потребителят избере билет и потвърди покупка
Then системата трябва да регистрира покупката
And да добави билета в профила му


Scenario:Покупка на вече продаден билет
Given че билетът вече е продаден
When потребител се опита да го закупи
Then системата трябва да покаже съобщение за грешка

Scenario: Покупка на билет без вход
Given че потребителят не е влязъл в системата
When се опита да закупи билет
Then системата трябва да го пренасочи към страницата за вход

Scenario: Покупка на билет за приключило събитие
Given че събитието за избрания билет вече е минало
When потребителят се опита да закупи билета
Then системата трябва да откаже покупката и да покаже съобщение

Scenario: Покупка с недостатъчна наличност по картата
Given че потребителят е въвел валидни картови данни
And наличната сума по картата е по-малка от цената на билета
When се опита да извърши транзакция
Then системата трябва да откаже покупката и да покаже съобщение за отказана трансакция

Scenario: Покупка с грешни картови данни
Given че потребителят е въвел невалидни картови данни
When се опита да извърши транзакция
Then системата трябва да откаже покупката
And да го върне обратно към формата за въвеждане на данни

Scenario: Покупка на билет с невалидна цена
Given че избраният билет има стойност 0 поради грешка
When потребителят се опита да го закупи
Then системата трябва да откаже покупката и да уведоми администратора