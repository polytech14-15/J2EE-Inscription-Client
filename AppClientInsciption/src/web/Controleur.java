package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meserreurs.MonException;

@WebServlet("/Controleur")
public class Controleur extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String AJOUTE_INSCRIPTION = "ajouteInscription";
	private static final String ENVOI_INSCRIPTION = "envoiInscription";
	private static final String ERROR_PAGE = null;

	// le format est une combinaison de MM dd yyyy avec / ou –
	// exemple dd/MM/yyyy
	public Date conversionChaineenDate(String unedate, String unformat) throws Exception {
		Date datesortie;
		// on définit un format de sortie
		SimpleDateFormat defFormat = new SimpleDateFormat(unformat, Locale.FRANCE);
		datesortie = defFormat.parse(unedate);

		return datesortie;
	}

	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MonException, Exception {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = ERROR_PAGE;

		// List<Stage> listeStages = null;
		// execute l'action

		if (AJOUTE_INSCRIPTION.equals(actionName)) {
//			request.setAttribute("stage", new Stage());
			destinationPage = "/PostMessage.jsp";
		} else if (ENVOI_INSCRIPTION.equals(actionName)) {
			try {
//				Stage unStage = new Stage();
//				unStage.setId(request.getParameter("id"));
//				unStage.setLibelle(request.getParameter("libelle"));
//				unStage.setDatedebut(conversionChaineenDate(request.getParameter("datedebut"), "dd/MM/yyyy"));
//				unStage.setDatefin(conversionChaineenDate(request.getParameter("datefin"), "dd/MM/yyyy"));
//				unStage.setNbplaces(Integer.parseInt(request.getParameter("nbplaces")));
//				unStage.setNbinscrits(Integer.parseInt(request.getParameter("nbinscrits")));
//				unStage.insertionStage();
				destinationPage = "/Accueil.jsp";
			} catch (Exception e) {
				request.setAttribute("MesErreurs", e.getMessage());
				System.out.println(e.getMessage());
			}
		}
		// Redirection vers la page jsp appropriee
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);
	}

	// L’appel de cette procédure se fait avec :

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processusTraiteRequete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processusTraiteRequete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
	}
}
