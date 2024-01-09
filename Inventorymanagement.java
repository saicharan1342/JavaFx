import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class Employee{
    int id;
    String name;
    double sal;
    String post;
    Employee(){}
    Employee(int i,String n,double s,String po){
        id=i;
        name=n;
        sal=s;
        post=po;

    }

}
class Inventory{
    String name;
    int quan,mrp;
    Inventory(){}
    Inventory(String n,int q,int m)
    {
        name=n;
        quan=q;
        mrp=m;
    }
}
public class App extends Application {
    public void start(Stage m) throws IOException{
        ArrayList<Employee> emp=new ArrayList<Employee>();
        ArrayList<Inventory> inv=new ArrayList<Inventory>();
        GridPane fpr=new GridPane();
        fpr.setAlignment(Pos.CENTER);
        fpr.setVgap(20);
        Button b1=new Button("Employee"),b2=new Button("Inventory"),e1=new Button("Create"),e2=new Button("Find"),submit=new Button("Submit");
        Button i1=new Button("Create"),i2=new Button("Sale"),i3=new Button("Order"),back=new Button("Back");
        fpr.add(b1,0,0);
        fpr.add(b2,0,1);
        Scene s1=new Scene(fpr,500,400);
        m.setScene(s1);
        m.setTitle("Inventory Management System");
        b1.setOnAction(empl->{
            GridPane fpr1=new GridPane();
            fpr1.setAlignment(Pos.CENTER);
            fpr1.setVgap(20);
            fpr1.add(e1,0,0);
            fpr1.add(e2,0,1);
            fpr1.add(back,0,2);
            Scene s2=new Scene(fpr1,500,400);
            m.setScene(s2);
            m.setTitle("Employee");
            e1.setOnAction(create->{
                GridPane fpr2=new GridPane();
                fpr2.setAlignment(Pos.CENTER);
                fpr2.setVgap(20);
                Label l1=new Label("ID:"),l2=new Label("Name:"),l3=new Label("Salary:"),l4=new Label("Position:");
                TextField t1=new TextField(),t2=new TextField(),t3=new TextField(),t4=new TextField();
                t1.promptTextProperty();
                fpr2.add(l1,0,0);
                fpr2.add(t1,1,0);
                fpr2.add(l2,0,1);
                fpr2.add(t2,1,1);
                fpr2.add(l3,0,2);
                fpr2.add(t3,1,2);
                fpr2.add(l4,0,3);
                fpr2.add(t4,1,3);
                fpr2.add(submit,1,4);
                Scene s3=new Scene(fpr2,500,500);
                m.setScene(s3);
                m.setTitle("Create Employee");
                submit.setOnAction(sub->{
                    if(t1.getText().trim().isEmpty() || t2.getText().trim().isEmpty() || t3.getText().trim().isEmpty() || t4.getText().trim().isEmpty())
                    {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("Info incomplete");
                        alert.setTitle("Message Here...");
                        alert.setContentText("You have missed some information");
                        alert.showAndWait();
                    }
                    else{
                        int i;
                        for(i=0;i<emp.size();i++){
                            if(emp.get(i).id==Integer.parseInt(t1.getText()))
                            {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setHeaderText("ID already exists");
                                alert.setTitle("Message Here...");
                                alert.setContentText("Please enter a different ID");
                                alert.showAndWait();
                                break;
                            }
                        }
                        if(i==emp.size()){
                            emp.add(new Employee(Integer.parseInt(t1.getText()),t2.getText(),Double.parseDouble(t3.getText()),t4.getText()));
                            m.setScene(s2);
                            m.setTitle("Employee");
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Employee created");
                            alert.setTitle("Message Here...");
                            alert.setContentText("Employee created successfully");
                            alert.showAndWait();
                        }
                    }
                });
            });
            e2.setOnAction(find->{
                GridPane fpr3=new GridPane();
                fpr3.setAlignment(Pos.CENTER);
                fpr3.setVgap(20);
                Label l1=new Label("ID"),l2=new Label("Name"),l3=new Label("Salary"),l4=new Label("Post");
                TextField t1=new TextField(),t2=new TextField(),t3=new TextField(),t4=new TextField();
                t1.promptTextProperty();
                t2.setEditable(false);
                t3.setEditable(false);
                t4.setEditable(false);
                fpr3.add(l1,0,0);
                fpr3.add(t1,1,0);
                fpr3.add(l2,0,1);
                fpr3.add(t2,1,1);
                fpr3.add(l3,0,2);
                fpr3.add(t3,1,2);
                fpr3.add(l4,0,3);
                fpr3.add(t4,1,3);
                fpr3.add(submit,1,4);
                Scene s4=new Scene(fpr3,500,500);
                m.setScene(s4);
                m.setTitle("Find Employee");
                submit.setOnAction(sub->{
                    int i;
                    for(i=0;i<emp.size();i++){
                        if(emp.get(i).id==Integer.parseInt(t1.getText()))
                        {
                            t2.setText(emp.get(i).name);
                            t3.setText(Double.toString(emp.get(i).sal));
                            t4.setText(emp.get(i).post);
                            break;
                        }
                    }
                    if(i==emp.size()){
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("ID not found");
                        alert.setTitle("Message Here...");
                        alert.setContentText("Please enter a different ID");
                        alert.showAndWait();
                    }
                });
            });
            back.setOnAction(back1->{
                m.setScene(s1);
                m.setTitle("Inventory Management System");
            });
            
        });
        b2.setOnAction(invl->{
            GridPane inventory=new GridPane();
            inventory.setAlignment(Pos.CENTER);
            inventory.setVgap(20);
            inventory.add(i1,0,0);
            inventory.add(i2,0,1);
            inventory.add(i3,0,2);
            inventory.add(back,0,3);
            Scene s5=new Scene(inventory,500,400);
            m.setScene(s5);
            m.setTitle("Inventory");
            i1.setOnAction(creat->{
                Label l1=new Label("Product Name:"),l2=new Label("Mrp:");
                TextField t1=new TextField(),t2=new TextField();
                t1.promptTextProperty();
                GridPane fpr4=new GridPane();
                fpr4.setAlignment(Pos.CENTER);
                fpr4.setVgap(20);
                fpr4.add(l1,0,0);
                fpr4.add(t1,1,0);
                fpr4.add(l2,0,1);
                fpr4.add(t2,1,1);
                fpr4.add(submit,1,2);
                Scene s6=new Scene(fpr4,500,400);
                m.setScene(s6);
                m.setTitle("Create Inventory");
                submit.setOnAction(sub->{
                    if(t1.getText().trim().isEmpty() || t2.getText().trim().isEmpty())
                    {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("Info incomplete");
                        alert.setTitle("Message Here...");
                        alert.setContentText("You have missed some information");
                        alert.showAndWait();
                    }
                    else{
                        int i;
                        for(i=0;i<inv.size();i++){
                            if(inv.get(i).name.equals(t1.getText()))
                            {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setHeaderText("Product already exists");
                                alert.setTitle("Message Here...");
                                alert.setContentText("Please enter a different product name");
                                alert.showAndWait();
                                break;
                            }
                        }
                        if(i==inv.size()){
                            inv.add(new Inventory(t1.getText(),0,Integer.parseInt(t2.getText())));
                            m.setScene(s5);
                            m.setTitle("Inventory");
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Product created");
                            alert.setTitle("Message Here...");
                            alert.setContentText("Product created successfully");
                            alert.showAndWait();
                        }
                    }
                });
            });
            i2.setOnAction(invl1->{
                GridPane fpr5=new GridPane();
                fpr5.setAlignment(Pos.CENTER);
                fpr5.setVgap(20);
                Label l1=new Label("Product Name:"),l2=new Label("Quantity:"),l3=new Label("Amount:");
                TextField t1=new TextField(),t2=new TextField(),t3=new TextField();
                t1.promptTextProperty();
                t2.promptTextProperty();
                fpr5.add(l1,0,0);
                fpr5.add(t1,1,0);
                fpr5.add(l2,0,1);
                fpr5.add(t2,1,1);
                fpr5.add(l3,0,2);
                fpr5.add(t3,1,2);
                t3.setEditable(false);
                fpr5.add(back,0,3);
                fpr5.add(submit,1,3);
                Scene s7=new Scene(fpr5,500,500);
                m.setScene(s7);
                submit.setOnAction(sub->{
                    int i;
                    for(i=0;i<inv.size();i++){
                        if(inv.get(i).name.equals(t1.getText()))
                        {
                            if(t2.getText().trim().isEmpty()){
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setHeaderText("Enter Quantity");
                                alert.setTitle("Message Here...");
                                alert.setContentText("Please enter quantity");
                                alert.showAndWait();
                            
                            }
                            else if(inv.get(i).quan<Integer.parseInt(t2.getText()))
                            {
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setHeaderText("Insufficient Quantity");
                                alert.setTitle("Message Here...");
                                alert.setContentText("Please enter a quantity less than or equal to "+inv.get(i).quan);
                                alert.showAndWait();
                            }
                            else{
                                inv.get(i).quan-=Integer.parseInt(t2.getText());
                                t3.setText(Integer.toString(Integer.parseInt(t2.getText())*inv.get(i).mrp));
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setHeaderText("Sale Successful");
                                alert.setTitle("Message Here...");
                                alert.setContentText("Sale Successful");
                                alert.show();
                            }
                            break;
                        }
                    }
                    if(i==inv.size()){
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("Product not found");
                        alert.setTitle("Message Here...");
                        alert.setContentText("Please enter a different product name");
                        alert.showAndWait();
                    }
                });
                back.setOnAction(back1->{
                    m.setScene(s5);
                    m.setTitle("Inventory");
                });
            });
            i3.setOnAction(invl2->{
                GridPane fpr6=new GridPane();
                fpr6.setAlignment(Pos.CENTER);
                fpr6.setVgap(20);
                Label l1=new Label("Product Name:"),l2=new Label("Quantity:"),l3=new Label("Amount:"),l4=new Label("Quantity available:");
                TextField t1=new TextField(),t2=new TextField(),t3=new TextField(),t4=new TextField();
                t1.promptTextProperty();
                t2.promptTextProperty();
                fpr6.add(l1,0,0);
                fpr6.add(t1,1,0);
                fpr6.add(l2,0,1);
                fpr6.add(t2,1,1);
                fpr6.add(l3,0,2);
                fpr6.add(t3,1,2);
                t3.setEditable(false);
                t4.setEditable(false);
                fpr6.add(l4,0,3);
                fpr6.add(t4,1,3);
                fpr6.add(back,0,4);
                fpr6.add(submit,1,4);
                Scene s8=new Scene(fpr6,500,500);
                m.setScene(s8);
                submit.setOnAction(sub->{
                    int i,l=0;
                    boolean p=false;
                    for(i=0;i<inv.size();i++){
                        if(inv.get(i).name.equals(t1.getText()))
                        {
                            p=true;
                            l=i;
                            break;
                        }
                    }
                    if(p==false){
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("Product not found");
                        alert.setTitle("Message Here...");
                        alert.setContentText("Please enter a different product name");
                        alert.showAndWait();
                    }
                    else if(t2.getText().trim().isEmpty()){
                        Alert alert = new Alert(AlertType.INFORMATION);
                        t4.setText(Integer.toString(inv.get(l).quan));
                        alert.setHeaderText("Enter Quantity");
                        alert.setTitle("Message Here...");
                        alert.setContentText("Please enter quantity");
                        alert.showAndWait();
                    }
                    else{
                        inv.get(l).quan+=Integer.parseInt(t2.getText());
                        t3.setText(Integer.toString(Integer.parseInt(t2.getText())*inv.get(l).mrp));
                        t4.setText(Integer.toString(inv.get(l).quan));
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("Order Successful");
                        alert.setTitle("Message Here...");
                        alert.setContentText("Order Successful");
                        alert.show();
                        
                    }
                });
                back.setOnAction(back1->{
                    m.setScene(s5);
                    m.setTitle("Inventory");
                });
            });
            back.setOnAction(back1->{
                m.setScene(s1);
                m.setTitle("Inventory Management System");
            });
        });
        m.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
