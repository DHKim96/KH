package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ThumbnailInsertController
 */
@WebServlet("/insert.th")
public class ThumbnailInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThumbnailInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if (ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;

			String savePath = request.getSession().getServletContext().getRealPath("/resources/thumbnail_upfile/");

			// 전달된 파일 업로드(request 변환)
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new MyFileRenamePolicy());

			Board b = new Board();
			b.setBoardWriter(multiRequest.getParameter("userNo"));
			b.setBoardTitle(multiRequest.getParameter("title"));
			b.setBoardContent(multiRequest.getParameter("content"));

			ArrayList<Attachment> list = new ArrayList<>();
			for (int i = 1; i <= 4; i++) {
				String key = "file" + i;
				if (multiRequest.getOriginalFileName(key) != null) {
					// 첨부파일이 존재할 경우
					// Attachment 생성 -> 원본명, 수정된파일명, 폴더경로, 파일레벨 => list담기
					Attachment at = new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/thumbnail_upfile/");

					at.setFileLevel(i == 1 ? 1 : 2);

					list.add(at);
				}
			}

			int result = new BoardService().insertThumbnailBoard(b, list);

			// 응답뷰요청
			if (result > 0) { // 성공 -> /kh/list.th 재요청
				request.getSession().setAttribute("alertMsg", "성공적으로 게시글 등록하였습니다.");
				response.sendRedirect(request.getContextPath() + "/list.th");

			} else {
				request.setAttribute("errorMsg", "사진 게시글 작성 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);

			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
