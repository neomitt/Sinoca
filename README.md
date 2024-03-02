# Sinoca
Simple red black green casino


![Screenshot](https://github.com/neomitt/Sinoca/blob/main/screen1.png)

## Interface
![Screenshot](https://github.com/neomitt/Sinoca/blob/main/screen3.png)
![Screenshot](https://github.com/neomitt/Sinoca/blob/main/screen2.png)
## Code fragment
```java
   public void onClick(View view) {
        if (!r.isChecked() && !g.isChecked() && !b.isChecked()) {
            Toast.makeText(this, "Choose color.", Toast.LENGTH_SHORT).show();
        }
        else{
            try {
                SStavka =  Integer.parseInt(String.valueOf(stavka.getText()));
                if(SStavka> balll || SStavka <=0 ){
                    Toast.makeText(this, "insufficient funds or value less than zero.", Toast.LENGTH_SHORT).show();
                }
                else {
                    int rnd = random.nextInt(3)+1;
                    if(rnd == answ){
                        pol = 1;
                        balance = balance + (SStavka*xx1);
                        bal.setText("Balance:"+balance);
                    }
                    else {
                        pol = 0;
                        balance = balance - SStavka;
                        bal.setText("Balance:"+balance);
                    }
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("poll", pol);
                    intent.putExtra("stav", SStavka);
                    intent.putExtra("balan", balance);
                    intent.putExtra("stavv", SStavka*2);
                    startActivity(intent);
                }

            }catch (Exception e){
                Toast.makeText(this, "No values.", Toast.LENGTH_SHORT).show();
            }
        }
    }
```
### [Github teachers: gomarmadi](https://github.com/gomarmadi)
