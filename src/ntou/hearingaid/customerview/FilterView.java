package ntou.hearingaid.customerview;

import ntou.hearingaid.hearingaid.BodePlotActivity;
import ntou.hearingaid.hearingaid.MainActivity;
import ntou.hearingaid.hearingaid.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/*
 * �Ȼs�Ƥ���-�o�i�����γ]�w
 */

public class FilterView extends LinearLayout {

	private View view;
	private TextView FreqNo;	//�W�a��
	private TextView LowFreq;	//�C�W
	private TextView HiFreq;	//���W
	private Button BodePlotButton;	//BodePlot�˵�button
	private Context context;
	
	public FilterView(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = layoutInflater.inflate(R.layout.filterview,this);
		FreqNo = (TextView)view.findViewById(R.id.FreqNo);
		LowFreq = (TextView)view.findViewById(R.id.lowFreq);
		HiFreq = (TextView)view.findViewById(R.id.HiFreq);
		BodePlotButton = (Button)view.findViewById(R.id.bodeplotbutton);
		BodePlotButton.setOnClickListener(new OnClick());
	}
	
	/*
	 * �]�w�W�a�s��
	 * No - �s��
	 */
	public void setFreqNo(int No)
	{
		FreqNo.setText("�W�a"+Integer.toString(No));
	}
	
	/*
	 * ���o�C�W
	 * return LowFreq�ƭ�
	 */
	public int getLowFreq()
	{
		try
		{
			return Integer.parseInt(LowFreq.getText().toString());
		}
		catch(Exception e)
		{
			return -1;
		}
	}
	
	/*
	 * �]�w�C�W
	 * freq - �W�v
	 */
	public void setLowFreq(int freq)
	{
		LowFreq.setText(String.valueOf(freq));
	}
	
	/*
	 * ���o���W
	 * return HiFreq �ƭ�
	 */
	public int getHiFreq()
	{
		try
		{
			return Integer.parseInt(HiFreq.getText().toString());
		}
		catch(Exception e)
		{
			return -1;
		}
		
	}
	
	/*
	 * �]�w���W
	 * freq - �W�v
	 */
	public void setHiFreq(int freq)
	{
		HiFreq.setText(String.valueOf(freq));
	}
	
	//Button Click�ƥ�
	private class OnClick implements OnClickListener
	{

		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//�p�G���Ubodeplotbutton
			if(arg0.getId()==R.id.bodeplotbutton)
			{
				//�P�_�O�_�w��W�W�v
				if(!(HiFreq.getText().toString().equals("")||LowFreq.getText().toString().equals("")))
				{
					//�N��T�Ǧܥt�@�ӭ���
					Bundle bundle = new Bundle();
					bundle.putInt("LowFreq", Integer.parseInt(LowFreq.getText().toString()));
					bundle.putInt("HiFreq", Integer.parseInt(HiFreq.getText().toString()));
					
					Intent intent = new Intent();
					intent.setClass(context, BodePlotActivity.class);
					intent.putExtras(bundle);
					context.startActivity(intent);
				}
				else
				{
					Toast.makeText(context,"�п�J�W�a�d��!!", 5).show();
				}
			}
		}
		
	}
}