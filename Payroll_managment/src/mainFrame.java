

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;


public class mainFrame {
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JButton submitButton;
    private JButton updateButton;    //HRA = 20% OF BASIC
    private JTextField ct;          // DA = 50% OF BASIC
    private JTextField e_d;        // PF = 11 % BASIC
    private JTextField dt;          // TAX =2% OF BASIC
    private JTextField nt;           // NET SALARY = BASIC +HRA + DA - PF -TAX
    private JTextField dobt;
    private JTextField montht;
    private JTextField yeart;
    private JTextField salaryt;
    private JTextField taxt;
    private JTextField absentt;
    private JTextField pft;
    private JTextField t_da;
    private JTextField netsalary;
    private JButton PRINTButton;
    private  JTextField total_days;
    private  JTextField t_hra;
    private JButton DELETEButton;
    private JTextField email_t;
    private JTextField dojt;
    private JTextField aget;
    private JTextField emp_id;
    private JButton SEARCHButton;
    private JButton CALCULATEButton;
    private JTextArea area;
    private JButton GENERATERECIPTButton;
    private JTextField b_sal;

    public static void main(String[] args) {
        JFrame frame = new JFrame("mainFrame");
        frame.setContentPane(new mainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,600);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public mainFrame() {
        Connect();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name,Emp_id,designation,dob,contact,doj,email,age,bb_sal,month,year,basic_sal,tot_days,tax,abs,hra,da,pf,net_sal;

                Emp_id = e_d.getText();
                designation = dt.getText();
                name = nt.getText();
                dob=dobt.getText();
                contact=ct.getText();
                doj=dobt.getText();
                email=email_t.getText();
                age=aget.getText();
                bb_sal=b_sal.getText();
//                month=montht.getText();
//                year=yeart.getText();
//                basic_sal=salaryt.getText();
//                tot_days=total_days.getText();
//                tax=taxt.getText();
//                abs=absentt.getText();
//                hra=t_hra.getText();
//                da=t_da.getText();
//                pf=pft.getText();
//                net_sal=netsalary.getText();


                try {
                    pst = con.prepareStatement("insert into pay(employee_id,Designation,name,dob,contact_no,email_id,doj,age,basic_sal)values(?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, Emp_id);
                    pst.setString(2, designation);
                    pst.setString(3, name);
                    pst.setString(4, dob);
                    pst.setString(5, contact);

                    pst.setString(6,email);
                    pst.setString(7,doj);
                    pst.setString(8,age);
                    pst.setString(9,bb_sal);
//                    pst.setString(9,month);
//                    pst.setString(10,basic_sal);
//                    pst.setString(11,tot_days);
//                    pst.setString(12,tax);
//                    pst.setString(13,abs);
//                    pst.setString(14,hra);
//                    pst.setString(15,pf);
//                    pst.setString(16,da);
//                    pst.setString(17,net_sal);
//                    pst.setString(18,year);


                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Added");

                    ct.setText("");
                    dt.setText("");
                    nt.setText("");
                    dobt.setText("");
                    dojt.setText("");
                    email_t.setText("");
                    aget.setText("");
                    e_d.setText("");
                    e_d.requestFocus();
                    b_sal.setText("");
//                    montht.setText("");
//                    yeart.setText("");
//                    salaryt.setText("");
//                    total_days.setText("");
//                    taxt.setText("");
//                    absentt.setText("");
//                    t_hra.setText("");
//                    t_da.setText("");
//                    pft.setText("");
//                    netsalary.setText("");
                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String s;
                s= e_d.getText();
                try {
                    pst = con.prepareStatement("delete from pay where employee_id= ?");
                    pst.setString(1, s);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Deleted");


                    area.setText("");
                    ct.setText("");
                    dt.setText("");
                    nt.setText("");
                    dobt.setText("");
                    dojt.setText("");
                    email_t.setText("");
                    aget.setText("");
                    e_d.setText("");
                    e_d.requestFocus();
                    b_sal.setText("");
//
                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name,Emp_id,designation,dob,contact,doj,email,age,basic_sal;

                Emp_id = e_d.getText();
                designation = dt.getText();
                name = nt.getText();
                dob=dobt.getText();
                contact=ct.getText();
                doj=dobt.getText();
                email=email_t.getText();
                age=aget.getText();
                basic_sal=b_sal.getText();



                try {
                    pst = con.prepareStatement("update pay set Designation=?,name=?,dob=?,contact_no=?,email_id=?,doj=?,age=?,basic_sal=? where employee_id=?");
                    pst.setString(1,designation);
                    pst.setString(2,name);
                    pst.setString(3,dob);
                    pst.setString(4,contact);
                    pst.setString(5,email);
                    pst.setString(6,doj);
                    pst.setString(7,age);
                    pst.setString(8,basic_sal);
                    pst.setString(9,Emp_id);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Updates");

                    e_d.setText("");
                    dt.setText("");
                    nt.setText("");
                    dobt.setText("");
                    ct.setText("");
                    dobt.setText("");
                    email_t.setText("");
                    aget.setText("");
                    b_sal.setText("");
                    dojt.setText("");

                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String eid = e_d.getText();
                    pst = con.prepareStatement("select Designation,name,dob,contact_no,email_id,doj,age,basic_sal from pay where employee_id = ?");
                    pst.setString(1, eid);
                    ResultSet rs = pst.executeQuery();

                    if(rs.next()==true)
                    {
                        String desi = rs.getString(1);
                        String name = rs.getString(2);
                        String dob = rs.getString(3);
                        String cont = rs.getString(4);
                        String email = rs.getString(5);
                        String doj = rs.getString(6);
                        String age = rs.getString(7);
                        String basicc_s= rs.getString(8);

                        nt.setText(name);
                        dt.setText(desi);
                        dobt.setText(dob);
                        dojt.setText(doj);
                        email_t.setText(email);
                        ct.setText(cont);
                        aget.setText(age);
                        b_sal.setText(basicc_s);

                    }
                    else
                    {
                        dt.setText("");
                        nt.setText("");
                        dobt.setText("");
                        ct.setText("");
                        email_t.setText("");
                        aget.setText("");
                        e_d.setText("");
                        dojt.setText("");

                        JOptionPane.showMessageDialog(null,"Employee does not exist ");

                    }
                }

                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        CALCULATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int em_id = 0;
                String ei,m,t,h,d,ns,y,td,a,p;
                try {
                    String e_id=emp_id.getText();
                    pst=con.prepareStatement("select basic_sal from pay where employee_id=? ");
                    pst.setString(1,e_id);
                    ResultSet r=pst.executeQuery();
                    if (r.next()==true){

                        em_id=Integer.parseInt(r.getString(1));
                    }
                    else {
                        emp_id.setText("");
                        total_days.setText("");
                        taxt.setText("");
                        t_hra.setText("");
                        t_da.setText("");
                        netsalary.setText("");
                        pft.setText("");
                        absentt.setText("");

                        JOptionPane.showMessageDialog(null,"Employee does not exist ");
                    }
                    String bassic,totaal_dayss,abss;
//                    bassic=salaryt.getText();
                    totaal_dayss=total_days.getText();
                    abss=absentt.getText();

//                    int base=Integer.parseInt();
                    int tot_d=Integer.parseInt(totaal_dayss);
                    int abb=Integer.parseInt(abss);
                    float hra= (em_id*0.20f);
                    float da = ( em_id*0.50f);
                    float pf =  (em_id*0.11f);
                    float tax= (em_id*0.02f);
                    float per_day=em_id/tot_d;
                    float no_of_day_work=tot_d - abb;
                    float b=per_day*no_of_day_work;
                    float net_salay=b+hra+da-pf-tax;

                    pft.setText(String.valueOf(pf));
                    taxt.setText(String.valueOf(tax));
                    t_hra.setText(String.valueOf(hra));
                    t_da.setText(String.valueOf(da));
                    netsalary.setText(String.valueOf(net_salay));

//
                }
                catch (Exception ex){
//                    JOptionPane.showMessageDialog(null,"Invalid Basic salary");
                }
            }
        });
        GENERATERECIPTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ei,m,t,h,d,ns,y,td,a,p;

                try {
                    ei = emp_id.getText();
                    pst=con.prepareStatement("select name,basic_sal from pay where employee_id=?");
                    pst.setString(1,ei);
                    ResultSet j=pst.executeQuery();
                    if(j.next()) {
                        String namme = j.getString(1);
                        String bbb = j.getString(2);
                        nt.setText(namme);
                        b_sal.setText(bbb);
                    }
                    m = montht.getText();
                    t = taxt.getText();
                    h = t_hra.getText();
                    d = t_da.getText();
                    ns = netsalary.getText();
                    y = yeart.getText();
                    td = total_days.getText();
                    a = absentt.getText();
                    p = pft.getText();
                    int em_id = 0;
                    pst = con.prepareStatement("insert into pay1 (employee_id,year,basic_s,total_d,tax,absent,hra,pf,da,net_salary,month) values (?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, ei);
                    pst.setString(2, y);
                    pst.setString(3, b_sal.getText());
                    pst.setString(4, td);
                    pst.setString(5, t);
                    pst.setString(6, a);
                    pst.setString(7, h);
                    pst.setString(8, p);
                    pst.setString(9, d);
                    pst.setString(10, ns);
                    pst.setString(11, m);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Salary record added");





                    // new query

//                    pst = con.prepareStatement("select name,basic_sal from pay where employee_id=?");
//                    pst.setString(1, ei);
//                    ResultSet p1 = pst.executeQuery();
//                    String name= "";
//                    String sa="";
//                    if (p1.next()) {
//                        name = p1.getString(1);
//                         sa = p1.getString(2);
//
//
//                    }

                    // end of query

                    area.setText("\t\tYASR \n");
//                area.setText(area.getText()+"*       The company                 *\n");
                    String td1=total_days.getText();
                    String ab = absentt.getText();
                    String hhra=t_hra.getText();
                    int t1, ab1, m1;
                    t1 = Integer.parseInt(td1);
                    ab1 = Integer.parseInt(ab);
                    m1 = t1 - ab1;
//                    int m=Integer.parseInt(td)-Integer.parseInt(a);

                    area.setText(area.getText() + "------------------------------------------\n");
                    area.setText(area.getText() + "Employee id : " + emp_id.getText() + "\n");
                    area.setText(area.getText() + "Employee Name : "+nt.getText()+ "\n");
                    area.setText(area.getText() + "Payslip for the month of : " + montht.getText() + "\n");
                    area.setText(area.getText() + "Total days\t" + "Working days\t" + "absents\n");
                    area.setText(area.getText() + total_days.getText() + "\t\t" + m1 + "\t\t" + absentt.getText() + "\n");
                    area.setText(area.getText() + "-------------------------------------------\n");
                    area.setText(area.getText() + " Earnings \t\tDeductions\n");
                    area.setText(area.getText() + "--------------------------------------------\n");
                    area.setText(area.getText() + "BASIC : " + b_sal.getText()+ "\t\t" + "PF :" + pft.getText() + "\n");
                    area.setText(area.getText() + "H.R.A : " + hhra + "\t\t" + "TAX :" + taxt.getText() + "\n");
                    area.setText(area.getText() + "D.A :" + t_da.getText() + "\n\n\n\n\n\n");
                    area.setText(area.getText() + "----------------------------------------------\n");
                    area.setText(area.getText() + "NET SALARY :" + netsalary.getText() + "\n");
                    nt.setText("");
                    b_sal.setText("");

                }catch (Exception ew){
                    ew.printStackTrace();
                }


            }
        });
        PRINTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    area.print();
                    montht.setText("");
                    yeart.setText("");
                    salaryt.setText("");
                    total_days.setText("");
                    taxt.setText("");
                    absentt.setText("");
                    t_hra.setText("");
                    t_da.setText("");
                    pft.setText("");
                    netsalary.setText("");
                }catch (Exception ew){

                }
            }
        });
    }


    Connection con;
    PreparedStatement pst;
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pay", "root","Adarsh@3456");
            System.out.println("Success");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}